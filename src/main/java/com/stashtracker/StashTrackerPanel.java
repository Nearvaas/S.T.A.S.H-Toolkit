package com.stashtracker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;

/**
 * Side panel showing every STASH unit grouped by clue tier, with a coloured status dot per unit
 * (grey = not built, red = built but empty, green = filled) and an overall progress summary.
 */
class StashTrackerPanel extends PluginPanel
{
	private static final Color NOT_BUILT = ColorScheme.LIGHT_GRAY_COLOR.darker();
	private static final Color BUILT_EMPTY = new Color(0xD0, 0x6A, 0x4F);
	private static final Color FILLED = new Color(0x5F, 0xC9, 0x6A);

	private final StashTrackerPlugin plugin;
	private final StashTrackerConfig config;

	private final JLabel overallLabel = new JLabel();
	private final JCheckBox hideFilled = new JCheckBox("Hide filled");
	private final JPanel listPanel = new JPanel();

	private Set<StashUnit> built = EnumSet.noneOf(StashUnit.class);
	private Set<StashUnit> filled = EnumSet.noneOf(StashUnit.class);

	StashTrackerPanel(StashTrackerPlugin plugin, StashTrackerConfig config)
	{
		this.plugin = plugin;
		this.config = config;

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		add(buildHeader(), BorderLayout.NORTH);

		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		add(listPanel, BorderLayout.CENTER);

		rebuild();
	}

	private JPanel buildHeader()
	{
		final JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
		header.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));

		final JLabel title = new JLabel("STASH Tracker");
		title.setFont(FontManager.getRunescapeBoldFont());
		title.setForeground(Color.WHITE);
		title.setAlignmentX(Component.LEFT_ALIGNMENT);
		header.add(title);

		overallLabel.setFont(FontManager.getRunescapeSmallFont());
		overallLabel.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		overallLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		overallLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 6, 0));
		header.add(overallLabel);

		hideFilled.setSelected(config.hideFilledByDefault());
		hideFilled.setFocusable(false);
		hideFilled.setBackground(getBackground());
		hideFilled.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
		hideFilled.setAlignmentX(Component.LEFT_ALIGNMENT);
		hideFilled.addActionListener(e -> rebuild());
		header.add(hideFilled);

		final JButton reset = new JButton("Reset this account");
		reset.setFocusable(false);
		reset.setAlignmentX(Component.LEFT_ALIGNMENT);
		reset.addActionListener(e ->
		{
			final int choice = JOptionPane.showConfirmDialog(this,
				"Clear all built/filled progress for the current account?",
				"Reset STASH Tracker", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION)
			{
				plugin.resetCurrentAccount();
			}
		});
		header.add(Box.createVerticalStrut(4));
		header.add(reset);

		return header;
	}

	/** Replaces the tracked state and repaints. Must be called on the Swing EDT. */
	void update(Set<StashUnit> built, Set<StashUnit> filled)
	{
		this.built = built;
		this.filled = filled;
		rebuild();
	}

	private void rebuild()
	{
		listPanel.removeAll();

		final int totalFilled = filled.size();
		final int total = StashUnit.values().length;
		overallLabel.setText("Filled: " + totalFilled + " / " + total
			+ "   •   Built: " + built.size() + " / " + total);

		final boolean hide = hideFilled.isSelected();

		for (StashTier tier : StashTier.values())
		{
			final java.util.List<StashUnit> units = new java.util.ArrayList<>();
			int tierFilled = 0;
			for (StashUnit unit : StashUnit.values())
			{
				if (unit.getTier() != tier)
				{
					continue;
				}
				if (filled.contains(unit))
				{
					tierFilled++;
				}
				if (!(hide && filled.contains(unit)))
				{
					units.add(unit);
				}
			}

			final int tierTotal = (int) java.util.Arrays.stream(StashUnit.values())
				.filter(u -> u.getTier() == tier).count();

			listPanel.add(buildTierHeader(tier, tierFilled, tierTotal));

			for (StashUnit unit : units)
			{
				listPanel.add(buildRow(unit));
				if (config.showRequirements() && !filled.contains(unit))
				{
					final StashRequirements.Requirement req = StashRequirements.get(unit);
					if (req != null)
					{
						listPanel.add(buildRequirementLabel(req));
					}
				}
			}
			listPanel.add(Box.createVerticalStrut(6));
		}

		listPanel.revalidate();
		listPanel.repaint();
	}

	private JPanel buildTierHeader(StashTier tier, int tierFilled, int tierTotal)
	{
		final JPanel row = new JPanel(new BorderLayout());
		row.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		row.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 24));

		final JLabel name = new JLabel(tier.getDisplayName());
		name.setFont(FontManager.getRunescapeBoldFont());
		name.setForeground(tier.getColor());
		row.add(name, BorderLayout.WEST);

		final JLabel count = new JLabel(tierFilled + " / " + tierTotal);
		count.setFont(FontManager.getRunescapeSmallFont());
		count.setForeground(tierFilled == tierTotal ? FILLED : ColorScheme.LIGHT_GRAY_COLOR);
		row.add(count, BorderLayout.EAST);

		return row;
	}

	private JPanel buildRow(StashUnit unit)
	{
		final boolean isFilled = filled.contains(unit);
		final boolean isBuilt = built.contains(unit);

		final JPanel row = new JPanel(new BorderLayout(6, 0));
		row.setBackground(ColorScheme.DARK_GRAY_COLOR);
		row.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
		row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

		final JLabel dot = new JLabel("●");
		dot.setFont(FontManager.getRunescapeBoldFont());
		dot.setForeground(isFilled ? FILLED : (isBuilt ? BUILT_EMPTY : NOT_BUILT));
		row.add(dot, BorderLayout.WEST);

		final JLabel name = new JLabel(unit.getDisplayName());
		name.setFont(FontManager.getRunescapeSmallFont());
		name.setForeground(isFilled ? Color.WHITE : ColorScheme.LIGHT_GRAY_COLOR);
		name.setVerticalAlignment(SwingConstants.CENTER);
		row.add(name, BorderLayout.CENTER);

		final String status = isFilled ? "Filled" : (isBuilt ? "Built, empty" : "Not built");
		row.setToolTipText("<html><b>" + unit.getDisplayName() + "</b><br>" + unit.getTier().getDisplayName()
			+ " &bull; " + status + (config.allowManualToggle() ? "<br><i>Click to toggle filled</i>" : "")
			+ "</html>");

		if (config.allowManualToggle())
		{
			row.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			row.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					plugin.toggleFilledManually(unit);
				}

				@Override
				public void mouseEntered(MouseEvent e)
				{
					row.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					row.setBackground(ColorScheme.DARK_GRAY_COLOR);
				}
			});
		}

		return row;
	}

	private JLabel buildRequirementLabel(StashRequirements.Requirement req)
	{
		final JLabel label = new JLabel("<html><div style='width:200px'>" + req.getDescription() + "</div></html>");
		label.setFont(FontManager.getRunescapeSmallFont());
		label.setForeground(ColorScheme.LIGHT_GRAY_COLOR.darker());
		label.setBorder(BorderFactory.createEmptyBorder(0, 22, 4, 4));
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		return label;
	}
}

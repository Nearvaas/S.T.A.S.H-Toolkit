package com.stashtracker;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * A {@link FlowLayout} that wraps components onto multiple rows and — unlike plain FlowLayout —
 * reports a correct preferred size for those wrapped rows. This is what lets a wrapping grid behave
 * inside a vertical {@code BoxLayout} / scroll pane. Based on Rob Camick's well-known WrapLayout.
 */
class WrapLayout extends FlowLayout
{
	WrapLayout(int align, int hgap, int vgap)
	{
		super(align, hgap, vgap);
	}

	@Override
	public Dimension preferredLayoutSize(Container target)
	{
		return layoutSize(target, true);
	}

	@Override
	public Dimension minimumLayoutSize(Container target)
	{
		final Dimension minimum = layoutSize(target, false);
		minimum.width -= (getHgap() + 1);
		return minimum;
	}

	private Dimension layoutSize(Container target, boolean preferred)
	{
		synchronized (target.getTreeLock())
		{
			// find the width to wrap against, walking up until a laid-out ancestor is found
			Container container = target;
			while (container.getSize().width == 0 && container.getParent() != null)
			{
				container = container.getParent();
			}

			int targetWidth = container.getSize().width;
			if (targetWidth == 0)
			{
				targetWidth = Integer.MAX_VALUE;
			}

			final int hgap = getHgap();
			final int vgap = getVgap();
			final Insets insets = target.getInsets();
			final int horizontalInsetsAndGap = insets.left + insets.right + (hgap * 2);
			final int maxWidth = targetWidth - horizontalInsetsAndGap;

			final Dimension dim = new Dimension(0, 0);
			int rowWidth = 0;
			int rowHeight = 0;

			final int members = target.getComponentCount();
			for (int i = 0; i < members; i++)
			{
				final Component m = target.getComponent(i);
				if (!m.isVisible())
				{
					continue;
				}

				final Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();
				if (rowWidth + d.width > maxWidth)
				{
					addRow(dim, rowWidth, rowHeight);
					rowWidth = 0;
					rowHeight = 0;
				}

				if (rowWidth != 0)
				{
					rowWidth += hgap;
				}

				rowWidth += d.width;
				rowHeight = Math.max(rowHeight, d.height);
			}

			addRow(dim, rowWidth, rowHeight);

			dim.width += horizontalInsetsAndGap;
			dim.height += insets.top + insets.bottom + vgap * 2;

			final Container scrollPane = SwingUtilities.getAncestorOfClass(JScrollPane.class, target);
			if (scrollPane != null && target.isValid())
			{
				dim.width -= (hgap + 1);
			}

			return dim;
		}
	}

	private void addRow(Dimension dim, int rowWidth, int rowHeight)
	{
		dim.width = Math.max(dim.width, rowWidth);
		if (dim.height > 0)
		{
			dim.height += getVgap();
		}
		dim.height += rowHeight;
	}
}

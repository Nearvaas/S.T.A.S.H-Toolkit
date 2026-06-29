# STASH Tracker

A [RuneLite](https://runelite.net) plugin for Old School RuneScape that tracks every **STASH unit**
in the game — which ones you have **built** and which ones you have **filled** — in a checklist side
panel grouped by clue tier (Beginner → Master).

## Features

- **All 119 STASH units** with their location and clue tier.
- **Auto-detection** of state from your in-game actions — no manual upkeep:
  - **Built** is detected when a built STASH unit renders in your scene (a built STASH only appears
    for the player who built it).
  - **Filled / emptied** is detected from the deposit / withdraw chat message after you interact
    with a unit. The unit is identified by the object you clicked, falling back to your location.
- **Per-account** progress, persisted via RuneLite config between sessions.
- **Side panel** with a coloured status dot per unit
  (grey = not built, red = built but empty, green = filled), per-tier counts, an overall
  summary, and a **Hide filled** filter.
- **Required-item tracker** — the panel lists the exact items each unfilled STASH still needs
  (pulled from RuneLite's emote-clue data), so you know what to gather and keep.
- **Inventory highlighting** — items in your inventory / bank / equipment that still need to be
  deposited into a STASH are outlined, so you don't accidentally drop, sell or alch a needed item.
  Charged / degraded / trimmed variants are matched too.
- **World map markers** at every STASH location, coloured by state, with an *only unfilled* filter.
- **Manual toggle** fallback — click a row to flip its filled state (can be disabled in config).

## Building

Requires a **JDK 11+**.

```sh
./gradlew build          # compile + run tests
./gradlew run            # launch a dev RuneLite client with the plugin loaded
```

## Notes on detection

The game does not expose a per-STASH "filled" flag, so fill state is inferred from chat messages.
The message matching is intentionally loose (deposit / withdraw / fill / empty / build / remove) so
small wording changes don't break it. If you ever spot a unit that didn't update automatically, just
click its row in the panel to correct it.

## Data source

STASH locations and object ids mirror RuneLite's own clue-scroll `STASHUnit` data so they stay
accurate against the live game.

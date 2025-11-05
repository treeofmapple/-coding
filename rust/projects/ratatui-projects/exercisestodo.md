### 🧩 Exercise 1 – Hello Layout

Goal: Understand the basics of Ratatui’s layout system and widgets.

What to do:
- Create a terminal app that displays three blocks:
- - Header (“Ratatui Practice”)
- - Body (“Hello, Ratatui!”)
- - Footer (“Press q to quit”)
- Use Layout and Block widgets with borders and titles.
- Use crossterm for event handling — quit when pressing q.

Concepts learned: layout, blocks, borders, terminal rendering.

### 🪟 Exercise 2 – Dynamic Layout

Goal: Practice resizing and positioning widgets dynamically.

What to do:
- Make a layout that splits vertically into two panels.
- When resizing the terminal, panels should resize automatically.
- One panel shows static text; the other shows a list of items.

Bonus: Alternate background colors or borders to visualize the layout.

Concepts learned: adaptive layouts, alignment, spacing.

### 📜 Exercise 3 – Scrollable List

Goal: Add interactivity with a scrollable list.

What to do:

- Display a list of items (e.g., “Item 1” … “Item 100”).
- Allow the user to scroll up/down with arrow keys.
- Highlight the selected item.

Concepts learned: handling keyboard input, mutable state, conditional rendering.

### 📊 Exercise 4 – Live Updating Chart

Goal: Learn to draw and update widgets continuously.

What to do:

- Display a line chart (e.g., using ratatui::widgets::Chart).
- Continuously push random data points every few hundred milliseconds.
- Redraw the chart in real time.

Bonus: Add CPU or memory usage from sysinfo crate instead of random numbers.

Concepts learned: app loop, async updates, chart widgets.

### 🔀 Exercise 5 – Tabbed Interface

Goal: Organize multiple screens or panels.

What to do:

- Create a top navigation bar with 3 tabs (e.g., “Home”, “Stats”, “Settings”).
- Switch between them with left/right arrow keys.
- Each tab shows different widgets (text, chart, or list).

Concepts learned: managing multiple views, input mapping, shared app state.

### ⚙️ Exercise 6 – Mini Dashboard App

Goal: Combine everything into a small terminal dashboard.

What to do:

### Create an app that shows:

- A header (title and datetime)
- A tabbed main area (e.g., logs, stats, and help)
- A footer with key hints

### Add:
- Keyboard input handling
- Periodic updates (like random system metrics)
- A quit command

Concepts learned: full app structure, tick handling, event loop design.

<br>

## 🧠 Tips as You Learn

Use App struct to store your app’s state and selected tab.

Always separate drawing code from state update logic.

Read the Ratatui examples on GitHub
 — they’re gold.

Experiment with colors, styles, and different widgets (e.g., Table, Paragraph, List, Chart).

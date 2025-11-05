use crossterm::{
    event::{self, DisableMouseCapture, EnableMouseCapture, Event, KeyCode},
    execute,
    terminal::{EnterAlternateScreen, LeaveAlternateScreen, disable_raw_mode, enable_raw_mode},
};
use ratatui::{
    Terminal,
    layout::{Constraint, Direction, Layout},
    prelude::{Backend, CrosstermBackend},
    style::{Color, Style},
    text::Text,
    widgets::{Block, Borders, Paragraph},
};
use raton_2_1::run_terminal::run_outside_terminal;
use std::io;

fn main() -> io::Result<()> {
    if std::env::var("RERUN_IN_TERMINAL").is_err() {
        unsafe { std::env::set_var("RERUN_IN_TERMINAL", "1") };
        run_outside_terminal()?;
        return Ok(());
    }

    enable_raw_mode()?;
    let mut stdout = io::stdout();
    execute!(stdout, EnterAlternateScreen, EnableMouseCapture)?;
    let backend = CrosstermBackend::new(stdout);
    let mut terminal = Terminal::new(backend)?;

    let res = run_app(&mut terminal);
    disable_raw_mode()?;

    execute!(
        terminal.backend_mut(),
        LeaveAlternateScreen,
        DisableMouseCapture
    )?;
    terminal.show_cursor()?;

    if let Err(err) = res {
        eprintln!("{:?}", err)
    }

    Ok(())
}

fn run_app<B: Backend>(terminal: &mut Terminal<B>) -> io::Result<()> {
    loop {
        terminal.draw(|f| {
            let chunks = Layout::default()
                .direction(Direction::Vertical)
                .margin(1)
                .constraints([Constraint::Percentage(50), Constraint::Percentage(50)])
                .split(f.size());

            let top_panel = Paragraph::new("Static text panel")
                .block(Block::default().title("Top Panel").borders(Borders::ALL))
                .style(Style::default().bg(Color::Blue).fg(Color::White));

            let items = vec!["Item 1", "Item 2", "Item 3"];

            let bottom_panel = Paragraph::new(Text::from(items.join("\n")))
                .block(Block::default().title("Bottom Panel").borders(Borders::ALL))
                .style(Style::default().bg(Color::Black).fg(Color::Cyan));

            f.render_widget(top_panel, chunks[0]);
            f.render_widget(bottom_panel, chunks[1]);
        })?;

        if event::poll(std::time::Duration::from_millis(200))? {
            if let Event::Key(key) = event::read()? {
                if key.code == KeyCode::Char('q') {
                    return Ok(());
                }
            }
        }
    }
}

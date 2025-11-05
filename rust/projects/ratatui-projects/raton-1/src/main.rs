use std::io::{self, Result, stdout};
use std::time::{Duration, Instant};

use crossterm::{
    event::{self, Event, KeyCode, KeyModifiers},
    execute,
    terminal::{EnterAlternateScreen, LeaveAlternateScreen, disable_raw_mode, enable_raw_mode},
};

use ratatui::{
    Frame, Terminal,
    prelude::*,
    style::{Color, Modifier, Style},
    text::Text,
    widgets::{Block, BorderType, Borders, Paragraph},
};

#[derive(Debug, Default)]
struct App {
    should_quit: bool,
}

fn main() -> Result<()> {
    let mut terminal = setup_terminal()?;

    let mut app = App::default();

    let res = run_app(&mut terminal, &mut app);

    restore_terminal()?;

    if let Err(err) = res {
        println!("Error: {:?}", err);
    }

    Ok(())
}

fn setup_terminal() -> Result<Terminal<CrosstermBackend<io::Stdout>>> {
    enable_raw_mode()?;
    execute!(stdout(), EnterAlternateScreen)?;
    let backend = CrosstermBackend::new(stdout());
    let terminal = Terminal::new(backend)?;
    Ok(terminal)
}

fn restore_terminal() -> Result<()> {
    disable_raw_mode()?;
    execute!(stdout(), LeaveAlternateScreen)?;
    Ok(())
}

fn run_app(terminal: &mut Terminal<CrosstermBackend<io::Stdout>>, app: &mut App) -> Result<()> {
    let tick_rate = Duration::from_millis(250);
    let mut last_tick = Instant::now();

    loop {
        terminal.draw(|f| ui(f, app))?;

        let timeout = tick_rate
            .checked_sub(last_tick.elapsed())
            .unwrap_or_else(|| Duration::from_secs(0));
        if crossterm::event::poll(timeout)? {
            if let Event::Key(key) = event::read()? {
                if key.code == KeyCode::Char('q')
                    || (key.code == KeyCode::Char('c') && key.modifiers == KeyModifiers::CONTROL)
                {
                    app.should_quit = true;
                }
            }
        }

        if last_tick.elapsed() >= tick_rate {
            last_tick = Instant::now();
        }

        if app.should_quit {
            return Ok(());
        }
    }
}

fn ui(f: &mut Frame, _app: &App) {
    let main_layout = Layout::new(
        Direction::Vertical,
        [
            Constraint::Length(1),
            Constraint::Min(0),
            Constraint::Length(3),
        ],
    )
    .split(f.size());

    let block = Block::default()
        .borders(Borders::ALL)
        .style(Style::default().fg(Color::White))
        .title("Ratatui Minimal Example")
        .title_alignment(Alignment::Center)
        .border_type(BorderType::Rounded);

    f.render_widget(block, main_layout[1]);

    let inner_area = Block::default()
        .borders(Borders::ALL)
        .style(Style::default().fg(Color::White))
        .title("Ratatui Minimal Example")
        .title_alignment(Alignment::Center)
        .border_type(BorderType::Rounded)
        .inner(main_layout[1]);

    let content = Text::from(vec![
        Line::from("Welcome to the Rust Ratatui Interface!"),
        Line::from(""),
        Line::from("Press 'q' or Ctrl+C to quit."),
    ]);

    let paragraph = Paragraph::new(content)
        .style(
            Style::default()
                .fg(Color::Cyan)
                .add_modifier(Modifier::BOLD),
        )
        .alignment(Alignment::Center);

    f.render_widget(paragraph, inner_area);

    let help_text = Paragraph::new("Status: Running | Controls: q/Ctrl+C (Quit)")
        .style(Style::default().fg(Color::DarkGray))
        .alignment(Alignment::Left)
        .block(
            Block::default()
                .borders(Borders::TOP)
                .border_type(BorderType::Plain),
        );

    f.render_widget(help_text, main_layout[2]);
}

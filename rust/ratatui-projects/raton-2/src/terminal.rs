use std::{io::{self, Result, stdout}};
use crossterm::{execute, terminal::{EnterAlternateScreen, LeaveAlternateScreen, disable_raw_mode, enable_raw_mode}};
use ratatui::{Frame, Terminal, layout::{Alignment, Constraint, Direction, Layout}, prelude::CrosstermBackend, style::{Color, Style}, text::Text, widgets::{Block, BorderType, Borders}};

use crate::structs::App;

pub fn setup_terminal() -> Result<Terminal<CrosstermBackend<io::Stdout>>> {
    enable_raw_mode()?;
    execute!(stdout(), EnterAlternateScreen)?;
    let backend = CrosstermBackend::new(io::stdout());
    let terminal = Terminal::new(backend)?;
    Ok(terminal)
}

pub fn restore_terminal() -> Result<()> {
    disable_raw_mode()?;
    execute!(stdout(), LeaveAlternateScreen)?;
    Ok(())
}


pub fn ui(f: &mut Frame, _app: &App) {
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

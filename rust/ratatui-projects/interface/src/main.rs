use color_eyre::Result;
use crossterm::event::{self, Event};
use ratatui::{
    DefaultTerminal, Frame,
    widgets::{Block, Borders, Paragraph},
};

fn main() -> Result<()> {
    color_eyre::install()?;
    let mut terminal = ratatui::init();
    let result = run(&mut terminal);
    ratatui::restore();
    result
}

fn run(terminal: &mut DefaultTerminal) -> Result<()> {
    loop {
        terminal.draw(render)?;

        if let Event::Key(_) = event::read()? {
            break;
        }
    }
    Ok(())
}

fn render(frame: &mut Frame) {
    let greeting = Paragraph::new("Hello, world!")
        .block(Block::default().title("Greeting").borders(Borders::ALL));

    frame.render_widget(greeting, frame.area());
}

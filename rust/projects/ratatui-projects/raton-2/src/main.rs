use std::io;

use raton_2::{run_master::run_app, run_terminal::run_outside_terminal, structs::AppFunctions, terminal::{restore_terminal, setup_terminal}};

fn main() -> io::Result<()> {
    run_outside_terminal();
    let mut terminal = setup_terminal()?;
    let mut app_functions = AppFunctions::default();
    run_app(&mut terminal, &mut app_functions)?;
    restore_terminal()?;

    Ok(())
}

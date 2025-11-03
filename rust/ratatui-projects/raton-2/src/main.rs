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

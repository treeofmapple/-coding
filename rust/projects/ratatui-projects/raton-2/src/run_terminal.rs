use std::{
    io,
    path::PathBuf,
    process::{self, Command},
};

pub fn run_outside_terminal() -> io::Result<()> {
    let base_path = PathBuf::from(env!("CARGO_MANIFEST_DIR"));
    let exe_name = if cfg!(target_os = "windows") {
        format!("{}.exe", env!("CARGO_PKG_NAME"))
    } else {
        env!("CARGO_PKG_NAME").to_string()
    };

    let path = check_folders(&base_path, exe_name)?;

    println!("Launching: {}", path.display());

    #[cfg(target_os = "windows")]
    {
        let _ = Command::new("powershell")
            .args([
                "-Command",
                &format!(
                    "Start-Process -FilePath '{}' -NoNewWindow:$false",
                    path.display()
                ),
            ])
            .spawn()?;
    }

    #[cfg(not(target_os = "windows"))]
    {
        let path_str = path.to_str().ok_or_else(|| {
            io::Error::new(
                io::ErrorKind::InvalidData,
                format!("Path contains invalid UTF-8: {}", path.display()),
            )
        })?;
        let _ = Command::new("x-terminal-emulator")
            .arg("-e")
            .arg(path.to_str().unwrap())
            .spawn()?;
    }

    println!("Exiting current process");
    process::exit(0);
}

fn check_folders(base_path: &PathBuf, type_exe: String) -> io::Result<PathBuf> {
    let mut release_path = base_path.clone();
    release_path.push("target");
    release_path.push("release");
    release_path.push(&type_exe);

    let mut debug_path = base_path.clone();
    debug_path.push("target");
    debug_path.push("debug");
    debug_path.push(&type_exe);

    if release_path.exists() {
        println!("Found release build. Using: {}", release_path.display());
        Ok(release_path)
    } else if debug_path.exists() {
        println!(
            "Release build not found. Found debug build. Using: {}",
            debug_path.display()
        );
        Ok(debug_path)
    } else {
        Err(io::Error::new(
            io::ErrorKind::NotFound,
            format!(
                "Could not find executable in release ({}) or debug ({})",
                release_path.display(),
                debug_path.display()
            ),
        ))
    }
}

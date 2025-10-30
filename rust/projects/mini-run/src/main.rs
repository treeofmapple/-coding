use std::{error::Error, fs::{self, OpenOptions}, path::Path};

use chrono::Utc;
use mini_run::{consts::{CSV_FILES, STORED_FOLDER}, datagen::generator::generate_exame_medico};
use rand::thread_rng;
use rayon::{ThreadPoolBuilder, iter::{IndexedParallelIterator, IntoParallelRefIterator, ParallelIterator}};

fn main() -> Result<(), Box<dyn Error>> {
    println!("Starting data generation...");

    ThreadPoolBuilder::new()
        .num_threads(6)
        .build_global()
        .expect("Failed to configure Thead Pool");

    fs::create_dir_all(STORED_FOLDER)?;

    for file in &CSV_FILES {
        let path = Path::new(STORED_FOLDER).join(file);
        if path.exists() {
            println!("Removing old file: {}", path.display());
            fs::remove_file(&path)?;
        }
    }

    CSV_FILES.par_iter().enumerate().for_each(|(i, csv_name)| {
        let mut rng = thread_rng();
        let today = Utc::now().date_naive();

        let path = Path::new(STORED_FOLDER).join(csv_name);
        println!("Generating file: {}", path.display());

        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true)
            .open(&path)
            .expect("Failed to open file");

        match i {
            0 => generate_exame_medico(&mut rng, today, file).expect("Failed empresas"),
            _ => unreachable!(),
        }
    });

    println!("\nData generation complete!");
    Ok(())
}

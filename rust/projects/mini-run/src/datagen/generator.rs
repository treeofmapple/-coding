use std::{error::Error, fs::File};

use chrono::{Datelike, NaiveDate};
use csv::Writer;
use fake::{
    Fake,
    faker::{company::en::CompanyName, name::en::Name},
};
use rand::{Rng, seq::SliceRandom};

use crate::{
    consts::{NUM_EXAMES, TIPO_EXAME},
    datagen::helpers::utils::random_date_between,
    structs::exame_medico::ExameMedico,
};

pub fn generate_exame_medico<R: Rng + ?Sized>(
    rng: &mut R,
    today: NaiveDate,
    file: File,
) -> Result<(), Box<dyn Error>> {
    // let weights = [50, 20, 30];
    // let dist = WeightedIndex::new(&weights).unwrap();
    let mut wtr = Writer::from_writer(file);
    let afastamento = ["Sim", "Não"];
    let resultado = ["Apto", "Inapto"];
    let start_date = today.with_year(today.year() - 5).unwrap();
    let end_date = today;

    for i in 1..=NUM_EXAMES {
        let ex = ExameMedico {
            id_exame: i,
            empresa: CompanyName().fake::<String>(),
            medico_responsavel: Name().fake::<String>(),
            data_exame: random_date_between(start_date, end_date),
            tipo_exame: TIPO_EXAME[rng.gen_range(0..TIPO_EXAME.len())].to_string(),
            resultado: resultado.choose(rng).unwrap().to_string(),
            afastamento: afastamento.choose(rng).unwrap().to_string(),
        };
        wtr.serialize(&ex)?;
    }
    wtr.flush()?;
    println!("Generated total data {}", NUM_EXAMES);
    Ok(())
}

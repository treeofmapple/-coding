use chrono::NaiveDate;
use csv::Writer;
use fake::Fake;
use fake::faker::{
    chrono::en::Date, company::en::CompanyName, job::en::Title as JobTitle, lorem::en::Sentence,
    name::en::Name,
};
use rand::Rng;
use serde::Serialize;
use std::fs;
use std::collections::HashSet;
use std::fs::OpenOptions;

const NUM_EMPRESAS: u32 = 10000000;
const NUM_FUNCIONARIOS_CLIENTE: u32 = 20000000;
const NUM_FUNCIONARIOS_CLINICA: u32 = 2500000;
const NUM_TIPOS_EXAMES: u32 = 1000000;
const NUM_RISCOS_OCUPACIONAIS: u32 = 150000;
const NUM_EXAMES: u32 = 5000000;
const MAX_RISCOS_PER_EXAME: u32 = 8;

#[derive(Serialize, Debug)]
struct Empresa {
    id_empresa: u32,
    nome: String,
    cnpj: String,
    endereco: String,
}

#[derive(Serialize, Debug)]
struct FuncionarioCliente {
    id_funcionario: u32,
    id_empresa: u32,
    nome: String,
    cpf: String,
    data_nascimento: NaiveDate,
    cargo: String,
}

#[derive(Serialize, Debug)]
struct FuncionarioClinica {
    id_funcionario_clinica: u32,
    nome: String,
    crm: String,
    funcao: String,
}

#[derive(Serialize, Debug)]
struct TipoExame {
    id_tipos_exames: u32,
    nome_tipo: String,
    descricao: String,
}

#[derive(Serialize, Debug)]
struct RiscoOcupacional {
    id_risco_ocupacional: u32,
    nome_risco: String,
    descricao: String,
}

#[derive(Serialize, Debug)]
struct Exame {
    id_exames: u32,
    id_funcionario: u32,
    id_funcionario_clinica: u32,
    id_tipos_exames: u32,
    data_exame: NaiveDate,
}

#[derive(Serialize, Debug)]
struct RiscoOcupacionalExame {
    id_risco_ocupacional_exames: u32,
    id_exames: u32,
    id_risco_ocupacional: u32,
}

fn generated_cpf<R: Rng + ?Sized>(rng: &mut R) -> String {
    let s: String = (0..11).map(|_| rng.gen_range(0..10).to_string()).collect();
    format!("{}.{}.{}-{}", &s[0..3], &s[3..6], &s[6..9], &s[9..11])
}

fn gen_cpf<R: Rng + ?Sized>(rng: &mut R, used: &mut HashSet<String>) -> String {
    loop {
        let cpf = generated_cpf(rng);
        if used.insert(cpf.clone()) {
            return cpf;
        }
    }
}

fn generated_cnpj<R: Rng + ?Sized>(rng: &mut R) -> String {
    let s: String = (0..14).map(|_| rng.gen_range(0..10).to_string()).collect();
    format!("{}.{}.{}/{}-{}", &s[0..2], &s[2..5], &s[5..8], &s[8..12], &s[12..14])
}

fn gen_cnpj<R: Rng + ?Sized>(rng: &mut R, used: &mut HashSet<String>) -> String {
    loop {
        let cpf = generated_cnpj(rng);
        if used.insert(cpf.clone()) {
            return cpf;
        }
    }
}

fn main() -> Result<(), Box<dyn std::error::Error>> {
    let mut rng = rand::thread_rng();

    let csv_files = [
        (
            "empresas.csv",
            vec!["id_empresa", "nome", "cnpj", "endereco"],
        ),
        (
            "funcionario_cliente.csv",
            vec![
                "id_funcionario",
                "id_empresa",
                "nome",
                "cpf",
                "data_nascimento",
                "cargo",
            ],
        ),
        (
            "funcionario_clinica.csv",
            vec!["id_funcionario_clinica", "nome", "crm", "funcao"],
        ),
        (
            "tipos_exames.csv",
            vec!["id_tipos_exames", "nome_tipo", "descricao"],
        ),
        (
            "risco_ocupacional.csv",
            vec!["id_risco_ocupacional", "nome_risco", "descricao"],
        ),
        (
            "exames.csv",
            vec![
                "id_exames",
                "id_funcionario",
                "id_funcionario_clinica",
                "id_tipos_exames",
                "data_exame",
            ],
        ),
        (
            "risco_ocupacional_exames.csv",
            vec![
                "id_risco_ocupacional_exames",
                "id_exames",
                "id_risco_ocupacional",
            ],
        ),
    ];

    for (file, _) in &csv_files {
        if fs::metadata(file).is_ok() {
            fs::remove_file(file)?;
        }
    }

    {
        let mut used_cnpj= HashSet::new();
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[0].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_EMPRESAS {
            let empresa = Empresa {
                id_empresa: i,
                nome: CompanyName().fake::<String>(),
                cnpj: gen_cnpj(&mut rng, &mut used_cnpj),
                endereco: format!(
                    "Rua {} nº {}",
                    Name().fake::<String>(),
                    rng.gen_range(1..=9999)
                ),
            };
            wtr.serialize(&empresa)?;
        }
        wtr.flush()?;
        println!("Generated {} empresas.", NUM_EMPRESAS);
    }

    {
        let mut used_cpfs = HashSet::new();
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[1].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_FUNCIONARIOS_CLIENTE {
            let fc = FuncionarioCliente {
                id_funcionario: i,
                id_empresa: rng.gen_range(1..=NUM_EMPRESAS),
                nome: Name().fake::<String>(),
                cpf: gen_cpf(&mut rng, &mut used_cpfs),
                data_nascimento: Date().fake::<NaiveDate>(),
                cargo: JobTitle().fake::<String>(),
            };
            wtr.serialize(&fc)?;
        }
        wtr.flush()?;
        println!(
            "Generated {} funcionario_cliente records.",
            NUM_FUNCIONARIOS_CLIENTE
        );
    }

    {
        let funcoes = [
            "Médico do Trabalho",
            "Enfermeiro(a)",
            "Técnico de Enfermagem",
            "Fonoaudiólogo(a)",
        ];
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[2].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_FUNCIONARIOS_CLINICA {
            let fc = FuncionarioClinica {
                id_funcionario_clinica: i,
                nome: Name().fake::<String>(),
                crm: format!("CRM/SP {}", rng.gen_range(10000..=99999)),
                funcao: funcoes[rng.gen_range(0..funcoes.len())].to_string(),
            };
            wtr.serialize(&fc)?;
        }
        wtr.flush()?;
        println!(
            "Generated {} funcionario_clinica records.",
            NUM_FUNCIONARIOS_CLINICA
        );
    }
    
    {
        let tipos = [
            "ASO Admissional",
            "ASO Periódico",
            "ASO Demissional",
            "ASO de Retorno ao Trabalho",
            "Audiometria",
            "Espirometria",
            "Acuidade Visual",
            "Hemograma Completo",
            "Glicemia de Jejum",
            "Raio-X de Tórax",
        ];
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[3].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_TIPOS_EXAMES {
            let te = TipoExame {
                id_tipos_exames: i,
                nome_tipo: tipos[((i - 1) as usize) % tipos.len()].to_string(),
                descricao: Sentence(5..8).fake::<String>(),
            };
            wtr.serialize(&te)?;
        }
        wtr.flush()?;
        println!("Generated {} tipos_exames.", NUM_TIPOS_EXAMES);
    }

    {
        let riscos = [
            "Físico",
            "Químico",
            "Biológico",
            "Ergonômico",
            "De Acidente",
            "Ruído",
            "Calor",
            "Poeira",
            "Névoa",
            "Vibração",
            "Radiação",
            "Vírus",
            "Bactérias",
            "Fungos",
            "Esforço Físico Intenso",
        ];
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[4].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_RISCOS_OCUPACIONAIS {
            let ro = RiscoOcupacional {
                id_risco_ocupacional: i,
                nome_risco: riscos[((i - 1) as usize) % riscos.len()].to_string(),
                descricao: Sentence(5..8).fake::<String>(),
            };
            wtr.serialize(&ro)?;
        }
        wtr.flush()?;
        println!(
            "Generated {} risco_ocupacional records.",
            NUM_RISCOS_OCUPACIONAIS
        );
    }

        {
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[5].0)?;
        let mut wtr = Writer::from_writer(file);
        for i in 1..=NUM_EXAMES {
            let ex = Exame {
                id_exames: i,
                id_funcionario: rng.gen_range(1..=NUM_FUNCIONARIOS_CLIENTE),
                id_funcionario_clinica: rng.gen_range(1..=NUM_FUNCIONARIOS_CLINICA),
                id_tipos_exames: rng.gen_range(1..=NUM_TIPOS_EXAMES),
                data_exame: Date().fake::<NaiveDate>(),
            };
            wtr.serialize(&ex)?;
        }
        wtr.flush()?;
        println!("Generated {} exames.", NUM_EXAMES);
    }

    {
        let file = OpenOptions::new()
            .write(true)
            .create(true)
            .truncate(true) 
            .open(csv_files[6].0)?;
        let mut wtr = Writer::from_writer(file);
        let mut junction_id_counter = 1;
        for i in 1..=NUM_EXAMES {
            let num_riscos_for_this_exame = rng.gen_range(1..=MAX_RISCOS_PER_EXAME);
            for _ in 0..num_riscos_for_this_exame {
                let r = RiscoOcupacionalExame {
                    id_risco_ocupacional_exames: junction_id_counter,
                    id_exames: i,
                    id_risco_ocupacional: rng.gen_range(1..=NUM_RISCOS_OCUPACIONAIS),
                };
                wtr.serialize(&r)?;
                junction_id_counter += 1;
            }
        }
        wtr.flush()?;
        println!(
            "Generated {} risco_ocupacional_exames records.",
            junction_id_counter - 1
        );
    }

    println!("\nData generation complete!");
    Ok(())
}

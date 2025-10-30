use chrono::NaiveDate;
use serde::Serialize;

#[derive(Serialize, Debug)]
pub struct ExameMedico {
    pub id_exame: u32,
    pub empresa: String,
    pub medico_responsavel: String,
    pub data_exame: NaiveDate,
    pub tipo_exame: String,
    pub resultado: String,
    pub afastamento: String,
}

use chrono::{Duration, NaiveDate};
use rand::Rng;

pub fn random_date_between(start: NaiveDate, end: NaiveDate) -> NaiveDate {
    let days_diff = (end - start).num_days();
    let random_days: i64 = rand::thread_rng().gen_range(0..=days_diff);
    start + Duration::days(random_days)
}

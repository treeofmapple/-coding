pub mod tests;

use std::io::{self, BufRead, Write};

fn grading_students(grades: &[i32]) -> Vec<i32> {
    grades
        .iter()
        .map(|&grade| {
            if grade < 38 {
                return grade;
            }
            let next_multiple = ((grade / 5) + 1) * 5;
            if next_multiple - grade < 3 {
                next_multiple
            } else {
                grade
            }
        })
        .collect()
}

#[allow(dead_code)]
fn grading_students2(grades: &[i32]) -> Vec<i32> {
    let mut final_grades = Vec::with_capacity(grades.len());

    for &grade in grades {
        if grade < 38 {
            final_grades.push(grade);
        } else {
            let next_multiple = ((grade / 5) + 1) * 5;
            if next_multiple - grade < 3 {
                final_grades.push(next_multiple);
            } else {
                final_grades.push(grade);
            }
        }
    }
    final_grades
}

fn main() {
    let stdin = io::stdin();
    let mut stdin_iterator = stdin.lock().lines();

    let mut fptr = io::stdout();

    let grades_count = stdin_iterator
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .parse::<i32>()
        .unwrap();

    let mut grades: Vec<i32> = Vec::with_capacity(grades_count as usize);

    for _ in 0..grades_count {
        let grades_item = stdin_iterator
            .next()
            .unwrap()
            .unwrap()
            .trim()
            .parse::<i32>()
            .unwrap();
        grades.push(grades_item);
    }

    let result = grading_students(&grades);

    for i in 0..result.len() {
        write!(&mut fptr, "{}", result[i]).ok();

        if i != result.len() - 1 {
            writeln!(&mut fptr).ok();
        }
    }

    writeln!(&mut fptr).ok();
}

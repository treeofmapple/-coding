#[allow(unused_imports)]
use std::{fs, path};

#[test]
fn test_weird_number() {
    let vars = path::Path::new(env!("CARGO_MANIFEST_DIR")).join("vars");
    for entry in fs::read_dir(vars).unwrap() {
        let path = entry.unwrap().path();
        if path.extension().map_or(false, |e| e == "in") {
            let src = fs::read_to_string(&path).expect("Failed to read .in file");
            let mut nums = src.split_whitespace().map(|x| x.parse::<i32>().unwrap());
            let n = nums.next().expect("File is empty");
            let arr: Vec<i32> = nums.collect();
            let expect_path = path.with_extension("out");
            let expect = fs::read_to_string(&expect_path)
                .expect("Missing corresponding .out file")
                .trim()
                .parse::<i32>()
                .unwrap();
            let result = crate::missing_number(n, &arr);
            assert_eq!(
                result,
                expect,
                "Failed on test case: {:?}",
                path.file_name().unwrap()
            );
        }
    }
}

/*

let number1 = 5;
let array = vec![2, 3, 1, 5];
let expect = 4;
assert_eq!(missing_number(number1, &array), expect);

*/

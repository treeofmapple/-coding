#[allow(unused_imports)]
use crate::grading_students;

#[test]
fn test_grading_students() {
    let array = vec![73, 67, 38, 33];
    let expected = vec![75, 67, 40, 33];
    assert_eq!(grading_students(&array), expected);
}

pub mod point {
  #[derive(Debug)]
  pub struct Point(i32, i32);
  impl Point {
    pub fn origin() -> Self { Point(0, 0) }
  }
}

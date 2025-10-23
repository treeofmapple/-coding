use testing_34::*;

fn main() {
  let mut p = point::Point::origin();
  p.0 += 1;
  println!("{p:?}");
}

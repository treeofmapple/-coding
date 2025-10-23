pub mod a {
  pub mod b {
    pub fn f() { println!("b1"); }
    pub mod c {
      pub fn f() { println!("c1"); }
    }
  }
  pub fn entry() { super::b::c::f(); }
}
pub mod b {
  pub fn f() { println!("b2"); }
  pub mod c {
    pub fn f() { println!("c2"); }
  }
}

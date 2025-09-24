fn main() {

    let guess: u32 = "42".parse().expect("Not a number");
    let guess2: u32 = 42;
    println!("{guess}");
    println!("{guess2}");
    
    // Signed
    
    let _garot1: i8;
    let _garot2: i16;
    let _garot3: i32;
    let _garot4: i64;
    let _garot5: i128;
    let _garot6: isize;
    
    // Unsigned
    
    let _garot11: u8; // Byte only
    let _garot12: u16;
    let _garot13: u32;
    let _garot14: u64;
    let _garot15: u128;
    let _garot16: usize;
    
    let _x = 2.0; // f64
    let _y: f32 = 3.0; // f32
    
    let sum: u32 = 5 + 10;
    let difference: f32 = 95.5 - 4.3;
    let product = 4 * 30;
    let quociente = 56.7 / 32.2;
    let truncated = -5 / 3;
    let remainder = 43 % 5;
    
    println!("{sum} : {difference} : {product} : {quociente} : {truncated} : {remainder}, end");
   
    
    let _t: bool = true;
    let _f: bool = false;
    
    let _c = 'z';
    let _z: char = 'z';
    let _heart_eyed_cat = '😻';

    let _tuples: (i32, f64, u8) = (500, 6.4, 1);
    let _tuples = (500, 6.4, 1);
    let (_x1,y2,_z3) = _tuples;
    println!("The vaule of y2 is: {y2}");
     
    
    
    
    
}


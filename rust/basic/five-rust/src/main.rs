fn main() {

    let x = 5;
    
    println!("The value of x is: {x}");
    
    // x = 6; 
    // cannot assign twice to an immutable variable.
    
    let alpha = 7;
    println!("The value of x is now: {alpha}");

    const THREE_HOURS_IN_SECONDS: u32 = 60 * 60 * 3; // aren't allowed to change
    
    println!("{THREE_HOURS_IN_SECONDS}");
    
    let b = 5;
    let b = b + 5;
    
    {
        let b = b * 2;
        println!("Inner Scope: {b}");
    }
    println!("Outscope: {b}");
    
    let mut spaces = "  "; // String
    
    spaces = spaces.len(); // num
    
    /* 
    * will throw an error cause of the second one because is thinking is a String instead of a num.
    */
}

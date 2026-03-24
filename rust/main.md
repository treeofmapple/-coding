Set 1: The Absolute Basics
Exercise 1: Hello, Rust!
Task: Write a program that prints the text "Hello, Rust!" to the console.

Concepts: The main function, the println! macro.

Exercise 2: Variables and Mutability
Task:

Declare an immutable variable x with a value of 10.

Declare a mutable variable y with a value of 20.

Print the initial values of x and y.

Change the value of y to 30.

Print the new value of y.

Concepts: let, let mut, basic data types (integers), printing variables.

Set 2: Functions and Control Flow
Exercise 3: Simple Function
Task:

Write a function called add that takes two integers (i32) as parameters.

The function should return the sum of the two numbers.

Call this function from your main function with two numbers and print the result.

Concepts: Function definitions, parameters, return values.

Exercise 4: Conditional Logic
Task: Write a program that takes an integer and prints whether it is "positive", "negative", or "zero".

Hint: Use an if/else if/else expression.

Concepts: Conditional statements.

Exercise 5: Simple Loop
Task: Use a for loop to print the numbers from 1 to 5, each on a new line.

Concepts: for loops, ranges (1..=5).

Set 3: Ownership and Structs
Exercise 6: Understanding Ownership
Task:

In main, create a String with some text.

Write a function display_message that takes a String as a parameter and prints it.

Call this function from main and pass your string to it.

Challenge: Try to print the string again in main after calling the function. Why does this fail? Read the compiler error!

Fix: Modify the function to take a reference to the string (&String) so it "borrows" the value instead of taking ownership.

Concepts: Ownership, borrowing, references (&).

Exercise 7: Simple Struct
Task:

Define a struct named Car with two fields: make (a String) and year (an unsigned integer, u32).

In your main function, create an instance of the Car struct.

Print out the make and year of your car.

Concepts: struct definition, creating instances, accessing fields.

Set 4: Enums and Collections
Exercise 8: Enums and match
Task:

Define an enum called Direction with four variants: Up, Down, Left, and Right.

Write a function that takes a Direction as an argument and uses a match statement to return a message like "Moving up!", "Moving down!", etc.

Call the function with one of the Direction variants and print the result.

Concepts: enum definition, match control flow.

Exercise 9: Using a Vector
Task:

Create a mutable Vec (vector) that can hold integers.

Add the numbers 10, 20, and 30 to the vector.

Write a for loop to iterate over the elements in the vector and print each one.

Concepts: Vec<T>, .new(), .push(), iterating over a collection.

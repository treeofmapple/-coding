package java_poo.Third_3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Book br1 = new Book("A","B","C");
		Book br2 = new Book("D","E","F");
		Book br3 = new Book("G","H","I");
		Book br4 = new Book("J","K","L");
		
		Book.addBook(br1);
		Book.addBook(br2);
		Book.addBook(br3);
		Book.addBook(br4);
		
		ArrayList <Book> bookCollection = Book.getBookCollection();
		
		System.out.println("List of Books:");
		for(Book book : bookCollection) 
			System.out.println(book.getTitle() + " by " + book.getAuthor() + " ,ISBN:"  + book.getISBN()); 
		
		Book.removeBook(br4);
		
		System.out.println("\nAfter removing " + br4.getTitle());
		System.out.println("List of Books:");
		for(Book book : bookCollection) 
			System.out.println(book.getTitle() + " by " + book.getAuthor() + " ,ISBN: " + book.getISBN());
		
		
	}
	
}

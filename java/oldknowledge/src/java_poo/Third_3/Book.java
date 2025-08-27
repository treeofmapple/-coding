package java_poo.Third_3;

import java.util.ArrayList;
import java.util.Objects;

public class Book {

	private String title;
	private String author;
	private String ISBN;
	private static ArrayList<Book> bookCollection = new ArrayList<Book>();

	public Book() {}
	
	public Book(String title, String author, String iSBN) {
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public static ArrayList<Book> getBookCollection() {
		return bookCollection;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public static void setBookCollection(ArrayList<Book> bookCollection) {
		Book.bookCollection = bookCollection;
	}
	
	public static void addBook(Book book) {
		bookCollection.add(book);
	}
	
	public static void removeBook(Book book) {
		bookCollection.remove(book);
	}
	

	@Override
	public String toString() {
		return String.format("Book = [title: %s, author: %s, ISBN: %s]", title, author, ISBN);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				&& Objects.equals(title, other.title);
	}

}

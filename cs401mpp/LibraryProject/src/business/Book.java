package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 121367432426051033L;

	private String title;
	private String ISBN;
	private int maxCheckoutDays;
	private List<BookCopy> copies = new ArrayList<>();
	private List<Author> authors = new ArrayList<>();

	public Book(String ISBN) {
		this.ISBN = ISBN;
	}

	public Book(String title, String ISBN, int maxCheckoutDays) {
		this.title = title;
		this.ISBN = ISBN;
		this.maxCheckoutDays = maxCheckoutDays;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getMaxCheckoutDays() {
		return maxCheckoutDays;
	}

	public void setMaxCheckoutDays(int maxCheckoutDays) {
		this.maxCheckoutDays = maxCheckoutDays;
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}

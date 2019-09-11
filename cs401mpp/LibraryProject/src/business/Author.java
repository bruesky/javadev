package business;

import java.io.Serializable;

public class Author extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2907979371878129798L;

	private Address address;
	private String credentials;
	private String bio;
	private Book book;

	public Author(String firstName, String lastName, String phoneNumber, String credentials, String bio) {
		super(firstName, lastName, phoneNumber);
		this.credentials = credentials;
		this.bio = bio;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
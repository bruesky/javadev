package dataaccess;

import java.util.ArrayList;
import java.util.List;

import application.Protocols;
import application.SystemManager;
import business.Address;
import business.Auth;
import business.Author;
import business.Book;
import business.LibraryMember;
import business.Staff;


public class TestData {
	private Protocols mgr = SystemManager.getInstance();

	@SuppressWarnings("serial")
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("Joe", "Thomas", "1233211234", "ccc", "bio"));
			add(new Author("Sandra", "Thomas", "1233211234", "ccc", "bio"));
			add(new Author("Sarah", "Connor", "1233211234", "ccc", "bio"));
			add(new Author("Nirmal", "Pugh", "1233211234", "ccc", "bio"));
//			add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
//			add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
//			add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
//			add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
//			add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
		}
	};
	

	void addBooks() {
		Book book = new Book("The Big Fish", "23-11451", 21);
		ArrayList<Author> authors = new ArrayList<Author>() ;
		authors.add(new Author("Joe", "Thomas", "1233211234", "ccc", "bio"));
		authors.add(new Author("Sandra", "Thomas", "1233211234", "ccc", "bio"));
	
		book.setAuthors(authors);
		mgr.saveBook(book);
		
		book = new Book("Antartica", "28-12331", 7);
		authors = new ArrayList<Author>() ;
		authors.add(new Author("Joe", "Thomas", "1233211234", "ccc", "bio"));
		authors.add(new Author("Sandra", "Thomas", "1233211234", "ccc", "bio"));
		book.setAuthors(authors);
		mgr.saveBook(book);
		
		book = new Book("Thinking Java", "99-22223", 21);
		authors = new ArrayList<Author>() ;
		authors.add(new Author("Joe", "Thomas", "1233211234", "ccc", "bio"));
		authors.add(new Author("Sandra", "Thomas", "1233211234", "ccc", "bio"));
		book.setAuthors(authors);
		mgr.saveBook(book);
		
		mgr.save(StorageType.BOOKS);
	}
	
	void addStaffs() {
		mgr.saveStaff(new Staff("101", "xyz", Auth.LIBRARIAN));
		mgr.saveStaff(new Staff("102", "abc", Auth.ADMIN));
		mgr.saveStaff(new Staff("103", "666", Auth.BOTH));
		mgr.saveStaff(new Staff("111", "222", Auth.BOTH));
		mgr.save(StorageType.STAFFS);
	}
	
	void addMembers() {
		mgr.saveLibraryMember(new LibraryMember("Xki", "Guo", "1233211234", "10001", addresses.get(0)));
		mgr.saveLibraryMember(new LibraryMember("Yj", "Jiang", "1233211234", "10002", addresses.get(1)));
		mgr.saveLibraryMember(new LibraryMember("Hua", "Wan", "1233211234", "10003", addresses.get(2)));
		mgr.save(StorageType.MEMBERS);
	}
	
	
	public static void main(String[] args) {
		TestData testData = new TestData();
		testData.addBooks();
		testData.addStaffs();
		testData.addMembers();
		
		System.out.println(SystemManager.getInstance().getBookByISBN("99-22223"));
		System.out.println(SystemManager.getInstance().getStaffByID("101"));
		System.out.println(SystemManager.getInstance().getLibraryMemberByID("10001"));
		
	}
	
}

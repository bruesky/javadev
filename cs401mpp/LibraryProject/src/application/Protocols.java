package application;

import business.Book;
import business.LibraryMember;
import business.Staff;
import dataaccess.StorageType;

public interface Protocols {
	
	public Staff getStaffByID(String id);
	public LibraryMember getLibraryMemberByID(String memberId);
	public Book getBookByISBN(String ISBN);
		
	// save a LibraryMember
	public int saveLibraryMember(LibraryMember libraryMember);
	
	// save a Book
	public int saveBook(Book book);
	
	// save a Staff
	public int saveStaff(Staff staff);
	
	//save to file
	public int save(StorageType type);
}

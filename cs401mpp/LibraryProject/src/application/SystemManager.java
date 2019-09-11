package application;

import business.Book;
import business.LibraryMember;
import business.Staff;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.StorageType;

public class SystemManager implements Protocols {
	
	private DataAccess dataAccess;
	
	private static SystemManager systemManager;
	private SystemManager() {
		dataAccess = new DataAccessFacade();
		
	}
	
	public static SystemManager getInstance() {
		if (systemManager==null) {
			systemManager = new SystemManager();
		}
		return systemManager;
	}
	
	public Staff getStaffByID(String id) {
		return dataAccess.getStaffByID(id);
	}
	
	public LibraryMember getLibraryMemberByID(String memberId) {
		return dataAccess.getLibraryMemberByID(memberId);
	}
	
	public Book getBookByISBN(String ISBN) {
		return dataAccess.getBookByISBN(ISBN);
	}
	
	// save a LibraryMember
	public int saveLibraryMember(LibraryMember libraryMember) {
		dataAccess.addNewMember(libraryMember);
		return 1;
	}
	
	// save a Book
	public int saveBook(Book book) {
		dataAccess.addNewBook(book);
		return 1;
	}
	
	public int saveStaff(Staff satff) {
		dataAccess.addNewStaff(satff);
		return 1;
	}
	
	public int save(StorageType type) {
		dataAccess.save(type);
		return 1;
	}
	
}

package dataaccess;

import business.Book;
import business.LibraryMember;
import business.Staff;

public interface DataAccess { 
	public LibraryMember getLibraryMemberByID(String memberId);
	public Book getBookByISBN(String ISBN);
	public Staff getStaffByID(String id);
	public void addNewMember(LibraryMember member);
	public void addNewBook(Book book);
	public void addNewStaff(Staff satff);
	public void save(StorageType type);
}

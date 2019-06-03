package project4stu.dataaccess;

import java.util.HashMap;

import project4stu.business.Book;
import project4stu.business.LibraryMember;
import project4stu.dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member); 
}

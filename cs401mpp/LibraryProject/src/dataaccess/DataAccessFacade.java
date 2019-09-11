package dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import business.Book;
import business.CheckoutRecord;
import business.LibraryMember;
import business.Staff;


public class DataAccessFacade implements DataAccess {
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "/src/dataaccess/storage";
	// mac "/src/dataaccess/storage"
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	//Data in memory
	//LibraryMember
	private HashMap<String, LibraryMember> members;
	//Book
	private HashMap<String,Book> books;
	//Staffs
	private HashMap<String, Staff> staffs;
	//Records
	private HashMap<String, CheckoutRecord> records;
	
	//Records
	private HashMap<StorageType, Object> all;
	
	
	public DataAccessFacade() {
		initData();
	}
	
	@SuppressWarnings("unchecked")
	public void initData() {
		members = (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
		books = (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
		staffs = (HashMap<String, Staff>) readFromStorage(StorageType.STAFFS);
		members = members==null?new HashMap<>() : members;
		books = books==null?new HashMap<>() : books;
		staffs = staffs == null? new HashMap<>():staffs;
		all = new HashMap<>();
		all.put(StorageType.MEMBERS, members);
		all.put(StorageType.BOOKS, books);
		all.put(StorageType.STAFFS, staffs);
	}
	
	public Staff getStaffByID(String id) {
		return staffs.get(id);
	}
	
	public LibraryMember getLibraryMemberByID(String memberId) {
		return members.get(memberId);
	}
	
	public Book getBookByISBN(String ISBN) {
		return books.get(ISBN);
	}
	
	
	public void addNewMember(LibraryMember member) {
		String memberId = member.getMemberId();
		members.put(memberId, member);
		save(StorageType.MEMBERS);
	}
	
	public void addNewCheckoutRecord(CheckoutRecord checkoutRecord) {
		String id = checkoutRecord.getLibraryMember().getMemberId();
		records.put(id, checkoutRecord);
	}
	
	public void addNewBook(Book book) {
		String bookISBN = book.getISBN();
		books.put(bookISBN, book);
		save(StorageType.BOOKS);
	}
	
	public void addNewStaff(Staff satff) {
		String id = satff.getUserId();
		staffs.put(id,satff);
		save(StorageType.STAFFS);
	}
	
	public void save(StorageType type) {
		saveToStorage(type, all.get(type));	
	}
	
	
	//SAVE TO FILE
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	//READ FROM FILE
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			if (Files.exists(path)) {
				in = new ObjectInputStream(Files.newInputStream(path));
				retVal = in.readObject();
			}else {
				Files.createFile(path);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
	
}

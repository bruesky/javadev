package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6207679889857228381L;
	
	private LibraryMember libraryMember;
	private List<CheckoutEntry> entries = new ArrayList<>();
	private List<FineRecord> fines = new ArrayList<>();

	public List<CheckoutEntry> getEntries() {
		return entries;
	}

	public List<FineRecord> getFines() {
		return fines;
	}

	public boolean addEntry(CheckoutEntry entry) {
		entry.setLendToMemberIdString(libraryMember.getMemberId());
		return entries.add(entry);
	}

	public boolean addFine(FineRecord fine) {
		return fines.add(fine);
	}

	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}

	public void setEntries(List<CheckoutEntry> entries) {
		this.entries = entries;
	}

	public void setFines(List<FineRecord> fines) {
		this.fines = fines;
	}

}
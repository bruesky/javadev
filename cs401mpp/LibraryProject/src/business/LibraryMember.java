package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7622983068510238034L;
	private String memberId;
	private Address addr;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String firstname, String lastname, String phoneNumber, String memberId, Address addr) {
		super(firstname, lastname, phoneNumber);
		this.memberId = memberId;
		this.addr = addr;
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		LibraryMember member = (LibraryMember) obj;
		return member.memberId == this.memberId;
	}

	public String toString() {
//		return String.format("|%15s|", memberId + "") + String.format("%15s|", getFirstName())
//				+ String.format("%15s|\n", getLastName());
		return ("Member ID is " + memberId + " First name: " + this.getFirstName() + 
				" Last Name: " + this.getLastName());
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
		this.checkoutRecord.setLibraryMember(this);
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}

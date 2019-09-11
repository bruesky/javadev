package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2312855779804973487L;
	
	private boolean isCheckedout;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private String lendToMemberIdString;
    
    public String getLendToMemberIdString() {
		return lendToMemberIdString;
	}

	public void setLendToMemberIdString(String lendToMemberIdString) {
		this.lendToMemberIdString = lendToMemberIdString;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private BookCopy bookCopy;
    
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCheckedout() {
		return isCheckedout;
	}

	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
		this.bookCopy.addCheckoutEntrys(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Checkout Entry";
	}
}

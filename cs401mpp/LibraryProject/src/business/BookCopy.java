package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookCopy implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8517552735563912947L;
	
	private int copyNumber;
    private boolean available = true;
    private List <CheckoutEntry> checkoutEntrys = new ArrayList<>();
   
	private final Book original;
    
    public BookCopy(Book original) {
        this.original = original;
    }
    
    public List<CheckoutEntry> getCheckoutEntrys() {
		return checkoutEntrys;
	}

	public void addCheckoutEntrys(CheckoutEntry checkoutEntry) {
		this.checkoutEntrys.add(checkoutEntry);
	}

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }   

    public Book getOriginal() {
        return original;
    }  
}
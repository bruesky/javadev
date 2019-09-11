/**
 * 
 */
package prob4;

/**
 * @author 610122
 *
 */
public abstract class Property {

	private Address address;
	private double rent;
	
	abstract double computeRent();

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}
	
}

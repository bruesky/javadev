/**
 * 
 */
package prob4;

/**
 * @author 610122
 *
 */
public class House extends Property {
	private double lotSize = 0.0;
	
	double computeRent() {
		return 0.1 * lotSize;
	}

	House(double lotSize) {
		this.lotSize = lotSize;
	}
	public double getLotSize() {
		return lotSize;
	}

	public void setLotSize(double lotSize) {
		this.lotSize = lotSize;
	}
	
}

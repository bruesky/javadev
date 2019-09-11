/**
 * 
 */
package prob4;

/**
 * @author 610122
 *
 */
public class Condo extends Property {
	private int floorNum = 0;
	
	Condo(int floorNum) {
		this.floorNum = floorNum;
	}
	
	double computeRent() {
		return 400 * floorNum;
	}
}

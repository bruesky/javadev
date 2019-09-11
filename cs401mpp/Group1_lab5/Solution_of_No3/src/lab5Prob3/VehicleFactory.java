/**
 * 
 */
package lab5Prob3;

/**
 * @author jiang
 *
 */
public class VehicleFactory {
	Vehicle getVehicle(String v) {
		if (Car.class.getSimpleName().equals(v)) {
			return new Car();
		} else if (ElectricCar.class.getSimpleName().equals(v)) {
			return new ElectricCar();
		} else if (Truck.class.getSimpleName().equals(v)) {
			return new Truck();
		} else if (Bus.class.getSimpleName().equals(v)) {
			return new Bus();
		} else {
			return null;
		}
	}
}

/**
 * 
 */
package lab5Prob3;

/**
 * @author jiang
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VehicleFactory vf = new VehicleFactory();
		// use factory to create vehicles
		Vehicle[] vehicles = { vf.getVehicle("Bus"), 
				vf.getVehicle("Truck"), 
				vf.getVehicle("Car"),
				vf.getVehicle("ElectricCar") };
		// invoke startEngine
		for (Vehicle v : vehicles) {
			v.startEngine();
		}
	}

}

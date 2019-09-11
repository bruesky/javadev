package prob4;

public class Driver {

	public static void main(String[] args) {

//		Object[] objects = { new House(9000), new Condo(2), new Trailer() };
//		double totalRent = Admin.computeTotalRent(objects);

		Property[] propertyArray = { new House(9000), new Condo(2), new Trailer() };
		double totalRent = Admin.computeTotalRent(propertyArray);
		System.out.println(totalRent);
	}
}

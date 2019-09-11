package lesson3.labs.prob3_inheritance;

public class Main {

	public static void main(String[] args) {
	  Cylinder c1 = new Cylinder(5.0, 10.0);
	  Circle c2 = new Circle(8.0);


	  System.out.println("with inheritance...");
	  System.out.println("Cylinder's volume is " + c1.computeVolume());
	  System.out.println("Circle's area is " + c2.computeArea());

	}

}

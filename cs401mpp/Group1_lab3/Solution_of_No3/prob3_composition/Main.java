package lesson3.labs.prob3_composition;

//with composition

public class Main {

	public static void main(String[] args) {
	  Circle cylinder_c = new Circle(5.0);
	  Cylinder c1 = new Cylinder(cylinder_c, 10.0);
	  Circle c2 = new Circle(8.0);


	  System.out.println("with composition...");
	  System.out.println("Cylinder's volume is " + c1.computeVolume());
	  System.out.println("Circle's area is " + c2.computeArea());

	}

}

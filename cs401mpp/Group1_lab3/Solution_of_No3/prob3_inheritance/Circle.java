package lesson3.labs.prob3_inheritance;

//inheritance

public class Circle extends Cylinder {
	private double radius;


	public Circle(double radius){
		super(radius,0);
	}

	public double getRadius(){
		return radius;
	}

	public double computeArea(){
		return Math.PI*radius*radius;
	}
}

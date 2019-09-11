package lesson3.labs.prob3_composition;

public class Cylinder {
	private double height;
	private Circle c;

	public Cylinder(Circle c, double height){
		this.c = c;
		this.height = height;
	}

	public double getHeight(){
		return height;
	}

	public double computeVolume(){
		return Math.PI*c.getRadius()*c.getRadius()*height;

	}

}

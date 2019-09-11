package lesson5.labs.prob2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figure f1 = new Triangle(3.0, 4.0);
		Figure f2 = new Rectangle(5.0, 6.0);
		Figure f3 = new Circle(10.0);
		
		ArrayList<Figure> l = new ArrayList<>();
		
		l.add(f1);
		l.add(f2);
		l.add(f3);
		
		double sumOfAreas = 0.0;
		
		for(Figure f: l) {
		//	System.out.println(f.computeArea());
			sumOfAreas += f.computeArea();
		}
		
		System.out.println("Sum of Areas = " + sumOfAreas);
	}

}

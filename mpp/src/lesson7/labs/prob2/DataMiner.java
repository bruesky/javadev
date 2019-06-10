package lesson7.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class DataMiner {
	List<Polygon> objects = new ArrayList<>();
	public static void main(String[] args) {
		DataMiner dm = new DataMiner();
		dm.objects.add(new EquilateralTriangle(12));
		dm.objects.add(new Ellipse(3,6));
		System.out.println(dm.computeAveragePerimeter());
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
		for(int i = 0; i < objects.size(); ++i) {
			sum += objects.get(i).computePerimeter();
		}
		return sum/objects.size();
	}

}

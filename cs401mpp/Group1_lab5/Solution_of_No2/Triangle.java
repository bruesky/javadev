package lesson5.labs.prob2;

public final class Triangle implements Figure{
	private final double base;
	private final double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
		
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		
		return  (base * height)/2;
	}

}

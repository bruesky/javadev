package lesson7.exercise_2_soln;

public enum Consts {
	COMPANY("Microsoft"),
	SALES_TARGET(20000000);
	
	private String strval;
	private int intval;
	// Create a Constructor to initialize various types of constants
	Consts(String s) {
		strval = s;
	}
	Consts(int val) {
		intval = val;
	}
	public String strval() {
		return strval;
	}
	public int intval() {
		return intval;
	}
	
	
}

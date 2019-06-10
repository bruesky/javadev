package lesson7.exercise_1_soln;

public interface StringList {
	//uncomment these
	
	abstract String[] strArray();
	abstract int size();
	abstract void setSize(int s);

	/** Adds a string to the end of the list */
	default public void add(String s) {	
		strArray()[size()] = s;
		setSize(size() + 1);
		
	}
	
	/** Gets the i_th string in the list */
	default public String get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArray()[i];
	}
	
}

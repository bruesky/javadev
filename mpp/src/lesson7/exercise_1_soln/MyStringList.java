package lesson7.exercise_1_soln;

import java.util.*;


public class MyStringList implements StringList {
	private static final int INITIAL_SIZE = 100;
	String[] strArray;
	int size;
	
	/* constructor */
	public MyStringList() {
		strArray = new String[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	@Override
	public String[] strArray() {
		return strArray;
	}
	@Override
	public void setSize(int x) {
		size = x;
	}
	
	//implementations of interface methods
	
	


	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		if(size > 0)
		   sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}


	
}

package MPP;

import java.util.ArrayList;
import java.util.LinkedList;

public class HelloMPP {
	
	public static void TestString() {
		String firstNameString = "Xiangkui";
		String lastNameString = "Guo";
		String nameString = firstNameString+" "+lastNameString;
		String subString = nameString.substring(0, 8);
		System.out.println(subString);
		String lowerCaseSubString = subString.toLowerCase();
		System.out.println(lowerCaseSubString);
		String upperCaseSubString = subString.toUpperCase();
		System.out.println(upperCaseSubString);
		String[] strs = nameString.split(" ");
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	public static void main(String[]args) {
		HelloMPP.TestString();
	}
}

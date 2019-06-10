package lesson7.lecture.reviewofinner.fourexamples;

import lesson7.lecture.reviewofinner.fourexamples.Member.Pair;

public class Local {
	private String name = "Joe";	
	public void printPair(int x, int y) {
		int a=10;
		class Pair {
			int first;
			int second;
			Pair() {		
			    printHello(name);
			}
			public String toString() {
				return "(" + first + ", " 
			               + second+ ")";
			}
			public void show()
			{
			//	a = a+10; // It is effectively final in Java 8 - in pre-java8 need declare as final
				System.out.println(a);
			}
		}
		Pair p = new Pair();
		p.first = x;
		p.second = y;
		System.out.println(p);
	}	
	private void printHello(String n) {
		System.out.println("Hello" );
	}
	public static void main(String[] args) {
		(new Local()).printPair(11, 3);
	}	
}

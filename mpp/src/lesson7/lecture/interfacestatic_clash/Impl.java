package lesson7.lecture.interfacestatic_clash;

public class Impl implements Sup1 , Sup2 {
	int x = myMethod();
	public static void main(String[] args) {
		int val = Sup1.myMethod();
		System.out.println(val);
		int val2 = Sup2.myMethod();
		System.out.println(val2);		
		int x = myMethod();
		System.out.println(x);
	}
	
	public static int myMethod() {
		return 4;
	}
}

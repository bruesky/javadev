package lesson7.lecture.defaultmethodrules.intfacesupclass;

public interface SupInt1 {
	default void myMethod(int x) {
		System.out.println("From SupInt1");
		System.out.println(x + 1);
	}
}

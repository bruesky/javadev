package lesson7.lecture.defaultmethodrules.intfaceclash.myexample;

// Super class wins - Super class & Interface clash
public class C2 extends C1 implements I2{
	void display(){
		myMethod();
		I2.super.myMethod();
	}

	public static void main(String[] args) {
	C2 obj = new C2();
	obj.myMethod();
	obj.display();
	}

}

package lesson7.lecture.defaultmethodrules.intfaceclash.myexample;

public class C3 implements I1,I2
{
	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		//I1.super.myMethod();
		I2.super.myMethod();
	}
	public static void main(String[] args) {
		new C3().myMethod();
	}

}

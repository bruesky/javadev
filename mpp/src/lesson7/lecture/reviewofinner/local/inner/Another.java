package lesson7.lecture.reviewofinner.local.inner;

public class Another {
	int z = 4;
    
	void myMethod(int y, final int x) {
		int w = 3;
		final int u = 4;
		class LocalInner {
			int innerVble = 8;

			private int inner() {
				int newInt = z + innerVble;
       			newInt += w; 
				newInt += y;
				newInt += x;
				newInt += u;
				return newInt;
			}
		}
		LocalInner obj =new LocalInner();
		System.out.println(obj.inner());
	}
	public static void main(String args[]){
		new Another().myMethod(5, 5);
	}
}


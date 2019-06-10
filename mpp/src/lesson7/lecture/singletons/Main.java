package lesson7.lecture.singletons;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {	
		MySingletonLazy lazy = MySingletonLazy.getInstance();	
		MySingletonLazy lazy1 = MySingletonLazy.getInstance();	
		
		MySingletonEnum myEnum = MySingletonEnum.INSTANCE;
		myEnum.usefulThings();
		MySingletonEnum myEnum1 = MySingletonEnum.INSTANCE;
		
	}

}

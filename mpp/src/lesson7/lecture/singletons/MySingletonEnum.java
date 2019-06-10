package lesson7.lecture.singletons;

/** Threadsafe singleton implementation; eager initialization */

interface MyInterface {
	default void usefulThings() {
		System.out.println("Default Method");
	}
  }

public enum MySingletonEnum implements MyInterface{
	INSTANCE;
	MySingletonEnum(){
		System.out.println("Object created using Enum");
	}
}

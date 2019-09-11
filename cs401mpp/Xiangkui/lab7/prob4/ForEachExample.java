package lesson7.labs.prob4;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		MyConsumer mc = new MyConsumer();
		list.forEach(mc);
	}
	
	//implement a Consumer
	static class MyConsumer implements Consumer<String>{
		@Override
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}
	
}
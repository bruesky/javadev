package lesson9.labs.prob7b;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		TriFunction<List<Employee>,Integer,Character,List<String>> pipeline =
				(emList,i,c)->{
				List<Employee> employeeList = LambdaLibrary.salaryGreaterThan.apply(emList,i);
				employeeList= LambdaLibrary.lastGreaterThan.apply(employeeList,c);
				List<String> nameList = LambdaLibrary.fullName.apply(employeeList);
				return nameList.stream().sorted().collect(Collectors.toList());
			};

		List<String> names = pipeline.apply(list,100000,'M');
		names.forEach(System.out::println);
	}

}

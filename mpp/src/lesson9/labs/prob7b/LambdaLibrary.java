package lesson9.labs.prob7b;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaLibrary {

    public static final BiFunction<List<Employee>,Integer,List<Employee>> salaryGreaterThan =
                (list, i) -> list.stream()
                                 .filter(employee -> employee.getSalary()>i)
                                 .collect(Collectors.toList());

    public static final BiFunction<List<Employee>,Character,List<Employee>> lastGreaterThan =
                (list,c)-> list.stream()
                               .filter(employee -> employee.getLastName().compareTo(""+c)>0)
                               .collect(Collectors.toList());

    public static final Function<List<Employee>,List<String>> fullName =
                (list)->list.stream()
                            .map(employee -> employee.getFirstName()+" "+employee.getLastName())
                            .collect(Collectors.toList());
}

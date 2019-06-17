package lesson10.labs.prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list){
        return list.stream().sorted().skip(1).findFirst().get();
    }

    public static class Person implements Comparable<Person>{
        public int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return "Age:"+this.age;
        }
    }

    public static void main(String[]args){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,9,8,0);
        System.out.println(secondSmallest(list));
        List<String> listStr = Arrays.asList("aa","ab","ac","ee");
        System.out.println(secondSmallest(listStr));
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person(12));
        listPerson.add(new Person(2));
        listPerson.add(new Person(42));
        System.out.println(secondSmallest(listPerson));
    }
}

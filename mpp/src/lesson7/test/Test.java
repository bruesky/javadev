package lesson7.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static <T extends Number> Double sumInfo(Collection<T> col){
        double sum = 0.0;
        for (T d:
             col) {
            sum+=d.doubleValue();
        }
         return sum;
    }

    public static <T extends Number, C extends Collection<T>> Double sumInfo2(C col){
        double sum = 0.0;
        for (T d:
                col) {
            sum+=d.doubleValue();
        }
        return sum;
    }

    public static  Double sumInfo3(Collection<? extends Number> col){
        double sum = 0.0;
        for (Number d:
                col) {
            sum+=d.doubleValue();
        }
        return sum;
    }

    public static Double sumInfo4(Collection<? extends Number> col) {
        return col.stream()
                .mapToDouble(n->n.doubleValue())
                .sum();
    }

    public static  Double sumInfo5(Collection<? extends Number> col){
        return col.stream()
                .map(n->n.doubleValue())
                .reduce(0.0, (a, b)->a+b);
    }

    public static void main(String[]args){
        List<Double> list = new ArrayList<>();
        list.add(1.8);
        list.add(4.4);
        list.add(9.);
        System.out.println(sumInfo3(list));
        char[] arr = {'a','c','d'};
        String zzz = Stream.of(arr).map(x->String.valueOf(x))
                .collect(Collectors.joining());
        zzz = Stream.of(arr).map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(zzz);

    }
}

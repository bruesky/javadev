package lesson8.labs.prob2.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    enum SortMethod {BYTITLE, BYPRICE};
    public static void sort(List<Product> list, final SortMethod method) {
        Collections.sort(list,(o1,o2)->{
            if(method == SortMethod.BYTITLE) {
                return o1.title.compareTo(o2.title);
            } else {
                if(o1.price == o2.price) return 0;
                else if(o1.price > o2.price) return 1;
                else return -1;
            }
        });
    }

    public static void main(String[]args){
        List<Product> list = new ArrayList<>();
        list.add(new Product("A",10.3,1));
        list.add(new Product("B",1.3,8));
        list.add(new Product("D",10.6,2));
        list.add(new Product("C",14.9,9));

        sort(list,SortMethod.BYPRICE);
        System.out.println(list);
        sort(list,SortMethod.BYTITLE);
        System.out.println(list);
    }
}

package lesson8.labs.prob2.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[]args){
        List<Product> list = new ArrayList<>();
        list.add(new Product("A",10.3,1));
        list.add(new Product("B",1.3,8));
        list.add(new Product("D",10.6,2));
        list.add(new Product("C",14.9,9));
        Collections.sort(list,new ProductPriceComparator());
        System.out.println(list);
    }
}

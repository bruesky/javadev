package lesson8.labs.d2prob3;

import java.util.Arrays;
import java.util.List;
public class Main {

    public static void main(String[]args){
        List<String> fruits = Arrays.asList("Apple","Banana","Orange","Cherries","Blums");
        //a
        fruits.forEach(str->System.out.println(str));
        //b
        fruits.forEach(System.out::println);
    }


}

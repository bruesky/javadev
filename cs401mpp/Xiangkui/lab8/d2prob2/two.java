package lesson8.labs.d2prob2;

import java.util.function.Supplier;

public class two {
    public static void main(String[]args){
        Supplier s = Math::random;
        System.out.println(s.get());
    }
}

package lesson8.labs.d2prob2;


import java.util.function.Supplier;

public class three {

    public three() {
        System.out.println(new MySupplier().get());
    }

    class MySupplier implements Supplier{

        @Override
        public Object get() {
            return Math.random();
        }
    }

    public static void main(String[]args){
        new three();
    }
}

package org.xkg.hellojava.programs.number;

public class FibonacciExample {

    public static int fibonacci(int index){
        if (index==1||index==2)
            return 1;
        else
            return fibonacci(index-1)+fibonacci(index-2);

    }

    public static int fibonacciWithoutRecursion(int index){
        if (index==1||index==2)
            return 1;
        else{
            int n1 = 1;
            int n2 = 1;
            int n3 = n2;
            for (int i = 3; i <= index;i++){
                n3 = n1+n2;
                n1 = n2;
                n2 = n3;
            }
            return n3;
        }
    }


    public static void main(String[]args){

        for (int i = 1; i <= 10;i++){
            System.out.println(fibonacciWithoutRecursion(i));
        }
    }

}

package org.xkg.hellojava.programs.number;

public class FactorialExample {

    public static int factorial(int num){
        int ret = 1;
        for (int i = 1; i <= num;i++){
            ret*=i;
        }
        return ret;
    }

    public static int factorial2(int num){
        if (num==0)
            return 1;
        else
            return num*factorial2(num-1);
    }

    public static void main(String[]args){
        System.out.println(factorial2(5));
    }
}

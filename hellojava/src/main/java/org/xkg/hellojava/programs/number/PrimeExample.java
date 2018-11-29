package org.xkg.hellojava.programs.number;

public class PrimeExample {

    static boolean isPrime(int n){
        if (n < 2)
            return false;
        else if (n==2)
            return true;
        else if (n%2==0)
            return false;
        else {
            int i;
            for (i = 3; i < n;i+=2){
                if (n%i==0)
                    break;
                if (i*i>n)
                    break;
            }
            if (i*i>n)
                return true;
            else
                return false;
        }
    }

    public static void main(String[]args){
        for (int i = 1; i < 100; i++){
            if (isPrime(i))
                System.out.println(i);
        }
    }
}

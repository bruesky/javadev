package cs435;

import java.util.Arrays;

public class lab2 {

    public static int[] merge(int[] arr1, int[] arr2){
        if (arr1==null||arr2==null)
            return null;
        else{
            if (arr1.length==0)
                return arr2;
            else if (arr2.length==0)
                return arr1;
            else {
                int[] ret = new int[arr1.length+arr2.length];
                int i = 0, j = 0, index = 0;
                while (i<arr1.length&&j<arr2.length)
                    ret[index++] = arr1[i]<=arr2[j]?arr1[i++]:arr2[j++];

                while (i<arr1.length)
                    ret[index++] = arr1[i++];

                while (j<arr2.length)
                    ret[index++] = arr2[j++];
                return ret;
            }
        }
    }

    public static int fib(int n){
        int ret = 0;
        if (n<2)
            ret = n;
        else {
            int a = 0;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                ret = a+b;
                a = b;
                b = ret;
            }
        }

        return ret;
    }

    public static void main(String[]args){
        for (int i = 0; i <= 15; i++) {
            System.out.println(fib(i));
        }
    }
}

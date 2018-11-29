package org.xkg.hellojava.programs.number;

public class PalindromeExample {

    public static boolean isPalindrome(int num){
        int sum = 0;
        int n = num;
        int r;
        while (n>0){
            r = n%10;
            sum = sum*10+r;
            n/=10;
        }

        return num==sum;
    }

    public static boolean isPalindrome2(int num){
       String numStr = ""+num;
       String numStr2 = new StringBuilder(numStr).reverse().toString();
       return numStr.equals(numStr2);
    }

    public static void main(String[]args){
        System.out.println(isPalindrome2(121));
    }


}

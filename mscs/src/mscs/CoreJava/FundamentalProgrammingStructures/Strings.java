package mscs.CoreJava.FundamentalProgrammingStructures;

import java.util.Scanner;

public class Strings {

    public static long repeatedString(String s, long n) {
        long num1 = 0;
        long num2 = 0;
        char[] arr = s.toCharArray();
        if (s.length()==1)
            return arr[0]=='a'?n:0;
        for (int i = 0; i < s.length(); i++) {

            if (arr[i]=='a')
                num1++;
            if (i<n%s.length()&&arr[i]=='a')
                num2++;
        }

        return n/s.length()*num1+num2;
    }

    public static void main(String[]args){
        System.out.println(repeatedString("a",1000000000000l));
        String loc = "Java";
        String hello = "Hello";
        String greeting = hello+" "+loc;
        System.out.println(greeting);
        String names = String.join(",","li","zhang");
        System.out.println(names);
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if (next.equals("."))
                break;
            stringBuilder.append(scanner.next());
        }
        System.out.println(stringBuilder.toString());
        System.out.println("world".equalsIgnoreCase("WORLD"));

        int[] codePoints = greeting.codePoints().toArray();
        for (int c:codePoints
             ) {
            System.out.println(c);
        }
    }
}

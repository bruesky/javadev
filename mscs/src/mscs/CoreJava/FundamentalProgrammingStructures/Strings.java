package mscs.CoreJava.FundamentalProgrammingStructures;

import java.util.Scanner;

public class Strings {

    public static void main(String[]args){
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
    }
}

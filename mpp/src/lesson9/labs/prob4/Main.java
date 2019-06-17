package lesson9.labs.prob4;

/*

public static void printSquares(int num)
which creates an IntStream using the iterate method.
The method prints to the console the first
num squares. For instance, if num = 4, then your method would output 1, 4, 9, 16.
Note: You will need to
come up with a function to be used in the second argument of iterate

*/

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main{

    public static void printSquares(int num){
        IntStream.iterate(1, (i) ->i+1)
                 .limit(num).map(x->x*x)
                 . forEach(System.out::println);
    }

    public static void main(String[]args){
        printSquares(4);
    }
}

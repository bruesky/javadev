package lesson9.labs.prob1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/*You have a Stream of Strings called stringStream consisting of the values “Bill”, “Thomas”,
and “Mary”. Write the one line of code necessary to print this stream to the console so that the
output looks like this:
Bill, Thomas, Mary
*/
public class Main {
    public static void main(String[]args){
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        System.out.println(stringStream.collect(Collectors.joining(",")));
    }
}

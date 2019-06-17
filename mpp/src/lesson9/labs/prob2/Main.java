package lesson9.labs.prob2;

import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*You have a Stream of Integers called myIntStream and you need to output both the
  maximum and minimum values. Write compact code that efficiently accomplishes this.
*/
public class Main {
    public static void main(String[]args){
        Stream<Integer> myIntStream = Stream.of(1,2,3,4,56,7,9,8);
        IntSummaryStatistics intSummaryStatistics = myIntStream.collect(Collectors.summarizingInt(n->n));
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
    }
}

package lesson9.labs.prob5;

import java.util.Arrays;
import java.util.stream.Stream;

public class Section {
    public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
        return stream.limit(n+1).skip(m);
    }
    public static void main(String[] args) {
        // Make three calls for the streamSection() method with different inputs
        // use nextStream() method to supply the Stream input as a first argument in streamSection() method
        streamSection(nextStream(),0,1).forEach(System.out::println);
        streamSection(nextStream(),3,7).forEach(System.out::println);
        streamSection(nextStream(),2,6).forEach(System.out::println);
    }
    //support method for the main method -- for testing
    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh",
                "iii").stream();
    }
}

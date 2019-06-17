package lesson9.labs.prob6;

/*public Set<String> union(List<Set<String>> sets)
by creating a stream pipeline that transforms a list of sets (of type String) into the union of those
sets. Make use of the reduce method for streams.
Example: The union method should transform the list [{“A”, “B”}, {“D”}, {“1”, “3”, “5”}] to the set
{“A”, “B”, “D”, “1”, “3”, “5”}.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public Set<String> union(List<Set<String>> sets){
        return sets.stream()
                   .flatMap(Set::stream)
                   .collect(Collectors.toSet());
    }

    public static void main(String[]args){
        List<Set<String>> setList = new ArrayList<>();
        setList.add(new HashSet<String>(Arrays.asList("A","B")));
        setList.add(new HashSet<String>(Arrays.asList("D")));
        setList.add(new HashSet<String>(Arrays.asList("1", "3", "5")));

        new Main().union(setList).forEach(System.out::println);
    }
}

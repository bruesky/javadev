package lesson9.labs.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 Implement a given method requirement using Lambdas and streams in a Java 8 way.
public int countWords(List<String> words, char c, char d, int len)
which counts the number of words in the input list words that have length equal to len, that
contain the character c, and that do not contain the character d.
*/
public class Main {
    public int countWords(List<String> words, char c, char d, int len){
        return (int) words.stream().filter((str)->{
                    return !str.contains(""+d)&&str.contains(""+c)&&str.length()==len;
                })
                .count();
    }


    public static void main(String[]args){
        List<String> strs  = Arrays.asList(new String[]{"coco","doc","coba","lil"});
        System.out.println(new Main().countWords(strs,'c','d',4));
    }
}

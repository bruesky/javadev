package org.xkg.hellojava.algorithm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class IncrementalMethod {

    public static void sum(){
        int[] array = {3, 6, 9, -8, 1};
        int sum = 0;
        for (int i=0; i<5; i++)
            sum += array[i];

        System.out.println(sum);
    }


    public static void copy(){
        String s = "incremental";
        char[] t = new char[s.length()];
        for (int j = 0; j < s.length(); j++) {
            t[j] = s.charAt(j);
        }
        System.out.println(new String(t));
    }

    public static void selection_sort(){
        Integer[] array = {3, 6, 9, -8, 1};

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex]>array[j])
                    minIndex = j;
            }

            if (minIndex!=i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

//        for (int num:
//             array) {
//            System.out.println(num);
//        }
        List<Integer> list = Arrays.asList(array);
        list.forEach(e->System.out.println(e));
        
    }

    public static void print_line(int n)  // n 是一行的長度
    {
        for (int i=1; i<=n; i++) System.out.print('@');
        System.out.println();
    }

    public static void print_triangle(int n)  // n 是行數
    {
        for (int i=n; i>=1; i--) print_line(i);
    }


    public static void main(String[]args){
        sum();
        copy();
        selection_sort();
        print_triangle(8);
    }

}

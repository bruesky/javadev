package org.xkg.hellojava.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */

//A method reference is described using "::" symbol.
public class MethodReferenceExample {
    public static void main(String args[]) {
        List nums = new ArrayList();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        int sum = 0;
        nums.forEach(MethodReferenceExample::add);
    }

    public static void add(Object o) {
        System.out.println(o);
    }
}

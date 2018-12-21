package org.xkg.hellojava.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class SockMerchant {


    public static void main(String[]args){
        int[]arr = {10,20,20,10,10,30,50,10,20};
        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for(int e : arr){
            if(!set.contains(e))
                set.add(e);
            else{
                set.remove(e);
                pairs++;
            }
        }
        System.out.println(pairs);
    }

}

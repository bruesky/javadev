package org.xkg.hellojava.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class WarmupChallenges {

    static int countingValleys(String s) {
        int v = 0;
        boolean in = false;
        int num = 0;
        for(int i = 0; i < s.length();i++){
            char now = s.charAt(i);
            if(now=='U')
                v++;
            else
                v--;
            if(v<0&&in==false)
                in = true;
            if(v>=0&&in==true){
                num++;
                in = false;
            }
        }
        return num;
    }

    static int sockMerchant(int[] ar) {
        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for(int e : ar){
            if(!set.contains(e))
                set.add(e);
            else{
                set.remove(e);
                pairs++;
            }
        }
        return pairs;
    }


    public static void main(String[]args){
        int[]arr = {10,20,20,10,10,30,50,10,20};

        System.out.println(sockMerchant(arr));

        String s = "UDDDUDUU";
        System.out.println(countingValleys(s));
    }

}

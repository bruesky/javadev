package org.xkg.hellojava.algorithm;

import org.xkg.hellojava.collections.ArrayListExample;
import org.xkg.hellojava.datastructures.Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class MemoizationMethod {


    public static void array_size()
    {
        int[] array = new int[100];
        int n = 0;      // 使用一個變數，記錄資料數量。
        array[n++] = 3; // 以便迅速地增加資料。
        array[n++] = 6;
        array[n++] = 9;
        System.out.println(n);
    }

    public static void counting_sort()
    {
        int[] array = {3, 6, 9, 9, 1};
        int[] c = new int[10];

        // 統計數字數量
        for (int i=0; i<5; i++)
            c[array[i]]++;

        // 由小到大讀取lookup table，順便排序數字。
        for (int j=0, i=0; j<10 && i<5; j++){
            while (c[j] > 0)
            {
                c[j]--;
                array[i++] = j;
            }
        }
    }


    public static void main(String[]args){
        array_size();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(2);//自加

    }
}

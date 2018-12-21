package org.xkg.hellojava.algorithm;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class EnumerationMethod {

    public static void find_minimum()
    {
        int[] array = {3, 6, 9, -8, 1};

        int min = Integer.MAX_VALUE;
        for (int i=0; i<5; i++) // 枚舉索引值
            if (array[i] < min) // 比較元素
                min = array[i]; // 隨時記錄最小值

        System.out.println(min);
    }

    public static void reverse_string()
    {
        String s = "Hello World!";
        char[] cs = s.toCharArray();

        // 兩個枚舉，一個從頭到尾，一個從尾到頭。
        for (int i=0, j=11; i<j; i++, j--){
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
        System.out.println(cs);
    }


    public static void main(String[]args){
        find_minimum();
        reverse_string();
    }
}

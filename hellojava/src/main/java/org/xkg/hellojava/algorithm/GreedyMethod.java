package org.xkg.hellojava.algorithm;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/21
 */
public class GreedyMethod {

    public static void main(String[] args) {
        int[] values = { 1, 2, 5, 10, 20, 50, 100, 500 };
        int[] counts = { 3, 1, 2, 1, 1, 3, 5 ,4};
        int[] num = change(1034, values, counts);
        print(num, values);
    }

    public static int[] change(int money, int[] values, int[] counts) {
        int[] result = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            int num = 0;
            int c = min(money / values[i], counts[i]);
            money = money - c * values[i];
            num += c;
            result[i] = num;
        }
        return result;
    }


    private static int min(int i, int j) {
        return i > j ? j : i;
    }

    private static void print(int[] num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num[i] != 0) {
                System.out.println(values[i] +" ： "+ num[i]);
            }
        }
    }
}

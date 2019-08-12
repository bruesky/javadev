package cs435;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lab6 {

    //0 .. 3n - 1,
    //O(n)
    public static int getFirstIntOccursOnce(int[] arr){
        int[] help = new int[arr.length*3-1];
        for (int e : arr){
            help[e]++;
        }
        for (int e: arr){
            if (help[e]==1)
                return e;
        }
        return -1;
    }

    public static void p2SolutionWithBucketSort(int[] arr){
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int e:
             arr) {
            if (max<e)
                max = e;
            if (min>e)
                min = e;
        }

        int offset = min>0?0:-min;
        int[] help = new int[offset+max+1];

        for (int e:
             arr) {
            help[e+offset]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            int e = help[i];
            while (e>0){
                arr[index++] = i-offset;
                --e;
            }
        }

        int[] ret = new int[arr.length];
        int i = 0, j = arr.length-1;
        index = 0;
        while (i<=j){
            ret[index++] = arr[i++];
            ret[index++] = arr[j--];
        }

        //out
        for (int k = 0; k < ret.length; k++) {
            System.out.println(ret[k]);
        }
    }

    //n = x*q + r
    public static void myRadixSort(int[] arr){
        List<List<Integer>> r = new ArrayList<>();
        List<List<Integer>> q = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            r.add(null);
            q.add(null);
        }

        for (int e:
             arr) {
            int remainder =  e%9;
            if (r.get(remainder)!=null)
                r.get(remainder).add(e);
            else {
                List<Integer> l = new ArrayList<>();
                l.add(e);
                r.set(remainder,l);
            }
        }

        for (int i = 0; i < r.size(); i++) {
            if (r.get(i)!=null){
                for (Integer e:
                     r.get(i)) {
                    int quotient = e/9;
                    if (q.get(quotient)!=null)
                        q.get(quotient).add(e);
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(e);
                        q.set(quotient,l);
                    }
                }
            }
        }

        int index = 0;
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i)!=null){
                for (Integer e:
                        q.get(i)) {
                    arr[index++] = e;
                }
            }
        }
    }


    public static void main(String[]args){
        System.out.println(getFirstIntOccursOnce(new int[]{1, 2, 4, 9, 3, 2, 1, 4, 5}));
        int[] arr = new int[]{80, 27, 72, 1, 27, 8, 64, 34, 16};
        myRadixSort(arr);
        for (int e:
             arr) {
            System.out.println(e);
        }

        int[] arr2 = new int[]{1,2,17,-4,-6,8};
        p2SolutionWithBucketSort(arr2);

    }
}

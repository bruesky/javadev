package cs435.Test.sortroutines;

import java.util.Arrays;
import cs435.Test.runtime.*;

public class QuickSort2 extends Sorter {
    //public sorting method
    private int[] help = new int[2];
    public int[] sort(int[] arr){
       quickSort(arr);
        return arr;
    }


    private  void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private  void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivotPos = medianOfThree(arr,l,r);
            swap(arr, pivotPos, r);

            int less = l-1;
            int more = r;
            int cur = l;
            while (cur<more){
                if (arr[cur]<arr[r]){
                    swap(arr,++less,cur++);
                }else if (arr[cur]>arr[r]){
                    swap(arr,--more,cur);
                }else {
                    cur++;
                }
            }
            swap(arr,more,r);

            quickSort(arr, l, less);
            quickSort(arr, more+1, r);
        }
    }

    private  void partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        help[0] = less+1;
        help[1] = more;
    }


    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] input = {4, 10, 7, 3, 9, 5, 2, 8, 1, 6};

        System.out.println(Arrays.toString(input));
        int[] result = qs.sort(input);

        System.out.println(Arrays.toString(result));
    }

    private void swap(int[] arr, int i, int j){
        if(arr == null || i == j || i >= arr.length || j >=arr.length) return;
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;

    }
    /** returns the position of the median of first, last, and middle array elements */
    private int medianOfThree(int[] arr, int left, int right){
        if(right-left < 2) return left;
        int center = (left+right)/2;
        //arrange the three
        if(arr[center] < arr[left]) swap(arr,center,left);
        if(arr[right] < arr[left]) swap(arr,right,left);
        if(arr[right] < arr[center]) swap(arr,right,center);
        return center;

    }
}

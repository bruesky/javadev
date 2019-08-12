package cs435.Test.sortroutines;
import cs435.Test.runtime.Sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTSort extends Sorter {
    int[] arr;
    @Override
    public int[] sort(int[] arr) {
        this.arr = arr;
        BSTSort(arr);
        return arr;
    }

    private void BSTSort(int[] arr){
        MyBST myBST = new MyBST();
        for (int e:
             arr) {
            myBST.insert(e);
        }
        myBST.bstSortHelp(this.arr,0);
    }

    public static void main(String[] args){
        int[] test = {21,13,1,-22, 51, 5, 18};
        BubbleSort bs = new BubbleSort();
        System.out.println(Arrays.toString(bs.sort(test)));
    }
}

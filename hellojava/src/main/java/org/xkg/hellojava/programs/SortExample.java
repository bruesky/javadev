package org.xkg.hellojava.programs;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

public class SortExample implements SortInterface {

    @Override
    public void sortFunc(int[] arr) {
        selectionSort(arr);
        bubbleSort(arr);
        insertionSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    SortUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                SortUtil.swap(arr, j, j + 1);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            SortUtil.swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args){
        SortExample sortExample = new SortExample();
        SortUtil.verify(sortExample);
    }
}

package org.xkg.hellojava.datastructures;

import java.util.Arrays;

public class Heap {
    private int[] arr = new int[99];
    private int totalSize = 0;

    public Heap() {
    }

    public void insert(int value) {
        int index = totalSize++;
        arr[index] = value;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public int[] getArr() {
        return arr;
    }

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public String toString() {
        return  Arrays.toString(Arrays.copyOfRange(arr,0,totalSize));
    }

    public void sort(){
        if (arr == null || totalSize < 2) {
            return;
        }

        int size = totalSize;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapSort(int[] arr,int size) {
        if (arr == null || size < 2) {
            return;
        }
        for (int i = 0; i < size; i++) {
            heapInsert(arr, i);
        }

//        swap(arr, 0, --size);
        while (size > 0) {
//            heapify(arr, 0, size);
            swap(arr, 0, --size);
            heapInsertFront(arr,arr[0],size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapInsertFront(int[] arr, int value, int size){
        int index = 0;

        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[]args){

        Heap heap = new Heap();
        heap.insert(3);
        heap.insert(9);
        heap.insert(1);
        heap.insert(19);
        heap.insert(19);
        heap.insert(0);
        heap.insert(5);

        System.out.println(heap);
//        Heap.heapSort(heap.getArr(),heap.getTotalSize());
        heap.sort();
        System.out.println(heap);
    }
}

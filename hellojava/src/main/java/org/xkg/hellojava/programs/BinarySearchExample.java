package org.xkg.hellojava.programs;

public class BinarySearchExample {

    public static int binarySearch(int[]arr,int first,int last,int key){
        while (first<=last){
            int mid = first+(last-first)/2;
            if (arr[mid]==key){
                return mid;
            }else if (key>arr[mid]){
                first = mid+1;
            }else {
                last = mid-1;
            }
        }

        return -1;
    }

    public static int binarySearchWithRecursion(int[]arr,int first,int last,int key){
        while (first<=last){
            int mid = first+(last-first)/2;
            if (arr[mid]==key){
                return mid;
            }else if (key>arr[mid]){
                return binarySearchWithRecursion(arr,mid+1,last,key);
            }else {
                return binarySearchWithRecursion(arr,first,mid-1,key);
            }
        }

        return -1;
    }


    public static int findMaxValueLessThanKey(int[]arr,int first,int last,int key){
        while (first<=last){
            int mid = first+(last-first)/2;
            if (arr[mid] >= key){
                last = mid-1;
            }else if (arr[mid] < key){
                first = mid+1;
            }
        }

        if (first==last+1)
            return last;
        else
            return -1;
    }



    public static void main(String[] args){

        int arr[] = {10,20,30,40,50};
        int key = 90;
        int last=arr.length-1;
        System.out.println(findMaxValueLessThanKey(arr,0,last,key));
    }
}

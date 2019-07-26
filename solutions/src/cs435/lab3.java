package cs435;

public class lab3 {


    //return -1 not found or return index
    public static int findFirstGreaterThanZero(int[] arr){
        int l = 0, r = arr.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (arr[mid]>0){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        if (l>r&&l<arr.length)
            return l;
        else
            return -1;
    }

    public static void find1sAnd0s(int[] arr){
        int index = findFirstGreaterThanZero(arr);
        int numOfZero = index==-1? arr.length:index;
        int numOfOne = arr.length-numOfZero;
        System.out.println("num of 1 : "+numOfOne);
        System.out.println("num of 0 : "+numOfZero);
    }

    public static void sort012Array(int[] arr){
        int l = -1;
        int r = arr.length;
        int cur = 0;
        while (cur<r){
            if (arr[cur]<1){
                swap(arr,++l,cur++);
            }else if (arr[cur]>1){
                swap(arr,--r,cur);
            }else {
                cur++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void bubbleSort1(int[] arr){
        boolean bSwap = false;
        for (int i = arr.length-1; i > 0 ; i--) {
            bSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    bSwap = true;
                }
            }
            if (!bSwap)
                return;
        }
    }

    public static void bubbleSort2(int[] arr){
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[]args){
        find1sAnd0s(new int[]{0,0,1,1,1,1});
        int[] arr = new int[]{3,5,2,6,1,8,0};
        bubbleSort1(arr);
        printArray(arr);
    }
}

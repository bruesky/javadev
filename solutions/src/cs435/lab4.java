package cs435;

public class lab4 {

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void partition(int[] arr, int l, int r,int[] help) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l)/2);
        partition(arr, l, mid,help);
        partition(arr, mid + 1, r,help);
        merge(arr, l, mid, r,help);
    }

    public static void merge(int[] arr, int l, int m, int r,int[] help) {
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        for (i = 0; i < r-l+1; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void reverseArr(int[] arr){
//        int[] help = new int[arr.length];
//        partition(arr,0,arr.length-1,help);
        reverseHelp(arr,0);
    }

    public static void reverseHelp(int[] arr, int index){
        int value = arr[index];
        if (index==arr.length-1){
            arr[arr.length-index-1] = value;
        }else {
            reverseHelp(arr,index+1);
            arr[arr.length-index-1] = value;
        }
    }

    public static void main(String[]args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        reverseArr(arr);
        printArray(arr);
    }
}

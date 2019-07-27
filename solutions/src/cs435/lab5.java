package cs435;

public class lab5 {

    // lim log(n)/n = 0 log(n) is o(n)
    public static int findAnElement(int[] arr){
        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        while (l<=r){
            mid = l+(r-l)/2;
            if (arr[mid]==mid)
                return mid;
            else if (arr[mid]>mid){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }

        return -1;
    }

    public static void qsort(int[] arr){
        quickSort(arr,0, arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l<r){
            swap(arr, l + (r-l)/2, r);
            int[] bounders = partition(arr,l,r);
            quickSort(arr,l,bounders[0]-1);
            quickSort(arr,bounders[1]+1,r);
        }
    }

    public static int[] partition(int[] arr,int l, int r){
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
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[]args){
//        System.out.println(findAnElement(new int[]{0,1}));
        int[] arr = new int[]{1,3,2,6,5,4,7,9,8};
        qsort(arr);
        lab4.printArray(arr);
    }
}

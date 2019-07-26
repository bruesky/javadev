package cs435;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class lab1 {

    //m = x*g
    //n = y*g
    //m = k*n+r
    //r = x*g-k*y*g = (x-k*y)*g
    public static int gcd(int m, int n){
        if (0==n) return m;
        return gcd(n,m%n);
    }

    public static int secondSmallest(int[] arr) {
        if(arr==null || arr.length < 2) {
            throw new IllegalArgumentException("Input array too small");
        }

        for (int i = 0; i < 2; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex]>arr[j])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr[1];
    }

    public static boolean isSum(List<Integer> arr,int startIndex, int sum, int target
                                ,List<Integer> arrayList,List<Integer> ret){
        if (startIndex==arr.size()){
            if (sum==target)
                ret.addAll(arrayList);
            return sum==target;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.addAll(arrayList);
        list2.addAll(arrayList);
        list2.add(arr.get(startIndex));
        return isSum(arr,startIndex+1,sum,target,list1,ret)
                ||isSum(arr,startIndex+1,sum+arr.get(startIndex),target,list2,ret);
    }

    public static void subSetSum(){

    }

    public static List<Integer> findSubsetSum(List<Integer> arr, int target){

        ArrayList<Integer> ret = new ArrayList<>();
        if (target==0)
            return ret;
        else
            if (isSum(arr,0,0,target,new ArrayList<>(),ret))
                return ret;
            else
                return null;
    }

    //        boolean[][] dp = new boolean[arr.length + 1][k + 1];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][k] = true;
//        }
//        for (int i = arr.length - 1; i >= 0; i--) {
//            for (int j = k - 1; j >= 0; j--) {
//                dp[i][j] = dp[i + 1][j];
//                if (j + arr[i] <= k) {
//                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
//                }
//            }
//        }
//
//        for (int i = 0; i < arr.length+1; i++) {
//            for (int j = 0; j < k; j++) {
//                if (dp[i][j])
//                    System.out.println(arr[i]);
//            }
//        }
//
//        System.out.println(dp[0][0]);

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            int oldSize = ret.size();
            for (int j = 0; j < oldSize; ++j) {
                List newVec = new ArrayList(ret.get(j));
                newVec.add(nums[i]);
                ret.add(newVec);
            }
        }
        return ret;
    }

    public static void helper(int[] nums,int index,List<List<Integer>> ret){
        if (index==nums.length){
            return;
        }

        int cur = nums[index];

        int size = ret.size();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>(ret.get(i));
            temp.add(cur);
            ret.add(temp);
        }

        helper(nums,index+1,ret);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        helper(nums,0,ret);
        return ret;
    }


    public static void main(String[]args){
        System.out.println(gcd(6,4));
        System.out.println(secondSmallest(new int[]{1, 3, 1, 3}));
        System.out.println(findSubsetSum(Arrays.asList(1, 3, 9, 4, 8, 5) ,999));
        System.out.println(subsets2(new int[]{1,2,3}));
    }
}

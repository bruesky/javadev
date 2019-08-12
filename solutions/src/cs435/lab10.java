package cs435;

import java.util.HashMap;
import java.util.Map;

public class lab10 {

    public static int longestSubsequence(String str1,String str2){
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int[][] d = new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i <= str1.length(); i++) {
            d[i][0] = 0;
        }

        for (int j = 0; j <= str2.length(); j++) {
            d[0][j] = 0;
        }

        for (int i = 1; i <= str1.length() ; i++) {
            for (int j = 1; j <=str2.length() ; j++) {
                if (str1Arr[i-1]==str2Arr[j-1])
                    d[i][j] = d[i-1][j-1]+1;
                else {
                    d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }

        return d[str1Arr.length][str2Arr.length];
    }


    public static int  perfectSquare(int n,Map<Integer,Integer> memoMap){
        if (memoMap.containsKey(n))
            return memoMap.get(n);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n;  i++) {
            if (i*i==n)
                return 1;
            else {
                min = Math.min(min,perfectSquare(n-i*i,memoMap)+1);
            }
        }

        memoMap.put(n,min);
        return min;
    }

    // Returns true if there is a subset of
    // set[] with sun equal to given sum
    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] =
                new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton
        // up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return subset[sum][n];
    }

    public static void main(String[]args){
//        System.out.println(longestSubsequence("regular","ruler"));
//        Map<Integer,Integer> map = new HashMap<>();
//        System.out.println(perfectSquare(13,map));

        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

}

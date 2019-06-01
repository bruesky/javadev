package sample2;

import java.util.Arrays;

public class Example_6 {


    static boolean isHaveZeroInbase(int n,int base){
        int num = n;
        while (num>0){
            if (num%base==0)
                return true;
            num /=base;
        }
        return false;
    }

    static int fullnessQuotient(int n){
        if (n<=0)
            return -1;
        int num = 0;
        int base  = 2;
        while (base<10){
            if (!isHaveZeroInbase(n,base)){
                num++;
            }
            base++;
        }

        if (num<1)
            return -1;
        else
            return num;
    }

    static int isFit(int[]a,int n){
        int totalNum = 0;
        int conNum = 0;
        for (int i = 0;i < a.length;i++){
            if (a[i]==n){
                totalNum++;
            }
        }

        for (int i = 0;i < a.length;i++){
            if (a[i]==n){
                conNum++;
            }else if(conNum>0&&a[i]!=n)
                break;
        }

        if (conNum==totalNum&&conNum==n)
            return conNum;
        else
            return 0;
    }

    static int isOddHeavy(int[]a){
        if (a == null||a.length<1)
            return 0;
        Arrays.sort(a);
        int minIndexOfOdd = a.length-1;
        if (a[minIndexOfOdd]%2!=1)
            return 0;
        for (int i = a.length-1;i>=0;i--){
            if (a[i]%2==1&&a[i]<=a[minIndexOfOdd])
                minIndexOfOdd = i;
        }
        for (int i = 0; i < a.length ;i++){
            if (i>minIndexOfOdd&&a[i]%2==0)
                return 0;
        }
        return 1;
    }

    static int isPacked(int[]a){
        if (a==null)
            return 0;

        for (int i = 0; i < a.length;i++){
            if (a[i]<=0)
                return 0;
            else {
                if (isFit(a,a[i])==0)
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[]args){
        int[]a = {-2,-4,-6,-8,-11};
        System.out.println(isOddHeavy(a));
    }
}

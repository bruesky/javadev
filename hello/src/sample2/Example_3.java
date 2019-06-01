package sample2;
import java.util.Arrays;

public class Example_3 {

    static int isIsolated(long n){
        if (n == 0)
            return 1;
        long square = n*n;
        long cube = n*n*n;
        while (square>0){
            long num = square%10;
            long temp = cube;
            while (temp>0){
                if (num==temp%10)
                    return 1;
                temp/=10;
            }
            square/=10;
        }
        return -1;
    }

    static boolean isAllSameDigit(int n,int digit){
        if (n==digit)
            return true;
        else {
            n = n>0?n:n*(-1);
            while (n != 0) {
                if (n % 10 != digit) {
                    return false;
                }
                n /= 10;
            }
        }
        return true;
    }

    static int isVanilla(int[]a){
        if (a == null)
            return 0;
        boolean bSame = true;
        if (a.length == 0)
            return 1;
        int digit = a[0]%10;
        for (int i = 0;i < a.length;i++){
            if (!isAllSameDigit(a[i],digit))
                bSame = false;
        }
        if (bSame)
            return 1;
        else
            return 0;
    }

    static int isTrivalent(int[]a){
        if (a == null||a.length<3)
            return 0;
        Arrays.sort(a);
        int value = a[0];
        int num = 1;
        for (int i = 1;i < a.length;i++){
            if (a[i]!=value){
                num++;
                value = a[i];
            }
        }
        if (num==3)
            return 1;
        else
            return 0;
    }

    public static void main(String[]args){
        int[]arr = {2147483647,-1,-1,-2147483648};
        System.out.println(isTrivalent(arr));
    }
}

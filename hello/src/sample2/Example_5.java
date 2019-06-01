package sample2;

public class Example_5 {


    static boolean haveNum2(int n){
        if (n == 0)
            return false;
        int num = n;
        while (num!=0){
            if (num%10==2)
                return true;
            num/=10;
        }
        return false;
    }

    static int smallest(int n){
        int start = 1;
        while (true){
            boolean bAllHaveNum2 = true;
            for (int i =1;i<=n;i++){
                if (!haveNum2(start*i))
                    bAllHaveNum2 = false;
            }
            if(bAllHaveNum2)
                return start;
            else
                start++;
        }
    }

    static int[]cluterCompression(int[]a){
        int num = 0;
        if (a == null||a.length==0)
            return new int[num];
        int value = a[0];
        num = 1;
        for (int i = 0;i < a.length;i++){
            if (value!=a[i]) {
                value = a[i];
                num++;
            }
        }
        int[] ret = new int[num];
        int index = 0;
        value = a[0];
        ret[index] = value;
        for (int i = 0;i < a.length;i++){
            if (value!=a[i]){
                value = a[i];
                index++;
                ret[index] = value;
            }
        }
        return ret;
    }

    static int isRailRoadTie(int a[]){
        if (a == null || a.length<2 || a[0]==0 || a[a.length-1]==0||(a.length-2)%3!=0)
            return 0;
        int index = 0;
        while (index<a.length){
            if ((index+1)%3==0){
                if (a[index]!=0)
                    return 0;
            }
            else {
                if (a[index] == 0)
                    return 0;
            }
            index++;
        }
        return 1;
    }

    static void print(int[]arr){
        for (int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[]args){
       int[]arr = {1};
       System.out.println(isRailRoadTie(arr));
    }
}

package sample2;

public class Example_7 {


    static int getExponent(int n,int p){
        if (p<=1)
            return -1;
        n = n>0?n:n*(-1);
        int times = 0;
        int pTimes = p;
        while (n>=pTimes){
            if (n%pTimes==0){
                pTimes*=p;
                times++;
            }else {
                break;
            }
        }
        return times;
    }


    static int is121Array(int[]a){
        if (a==null||a.length<3)
            return 0;

        int num1left = 0;

        for (int i = 0; i < a.length;i++){
            if (a[i]==1)
                num1left++;
            else
                break;
        }

        if (num1left==0||num1left==a.length)
            return 0;

        for (int i = 0;i < a.length;i++){
            if (i > num1left-1&&i<a.length-num1left&&a[i]!=2)
                return 0;
            if (i >= a.length-num1left&&a[i]!=1)
                return 0;
        }
        return 1;
    }

    static int [] parseNinBinary(int n){
        int numOfArray = 0;
        int num = n;
        if (n ==0 )
            return new int[]{};
        while (num>0){
            if (num%2!=0)
                numOfArray++;
            num/=2;
        }
        int[]ret = new int[numOfArray];
        num = n;
        int index = 0;
        int numIndex = 0;
        while (num>0){
            if (num%2!=0)
                ret[index++]=numIndex;
            num/=2;
            numIndex++;
        }
        return ret;
    }

    static int [] filterArray(int[]a,int n){
        int[]filter = parseNinBinary(n);
        if (a==null)
            return null;
        if (filter.length==0)
            return new int[]{};
        int num=0;
        for (int i = 0;i < filter.length;i++){
            if (filter[i]<a.length)
                num++;
            else
                return null;
        }
        int[]ret = new int[num];
        int index = 0;
        for (int i = 0;i < filter.length;i++){
            if (filter[i]<a.length)
                ret[index++] = a[filter[i]];
        }
        return ret;
    }

    static void printArr(int[]a){
        if (a==null){
            System.out.println("null");
            return;
        }

        for (int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }
    }


    public static void main(String[]args){
        int[]a = {0,9,12,18,-6};
//        System.out.println(is121Array(a));
        printArr(filterArray(a,11));
    }
}




























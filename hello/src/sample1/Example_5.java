package sample1;

public class Example_5 {
    public static int henry(int i,int j){
        int sum = 0;

        int n = 0;
        int startIndex = 1;
        int endIndex = i>j?i:j;
        while (n<endIndex){
            ++startIndex;
            int pSum = 0;
            for (int index = 1; index <= startIndex/2;index++){
                if (startIndex%index==0)
                    pSum+=index;
            }
            if (pSum==startIndex){
                n++;
                if (n==i)
                    sum+=pSum;
                if (n==j)
                    sum+=pSum;
            }
        }
        return sum;
    }

    public static int isDivisible(int[]a,int divisor){
        if (a == null||divisor==0)
            return 0;
        boolean bFail = false;
        for (int i = 0; i < a.length;i++){
            if(a[i]%divisor!=0)
                bFail = true;
        }
        if (bFail)
            return 0;
        else
            return 1;
    }

    public static int isNUnique(int[]a,int n){
        if(a==null||a.length<2)
            return 0;
        int nTimes = 0;
        for (int i = 0;i < a.length;i++){
            for (int j = 0;j < a.length;j++){
                if(i!=j){
                    if ((a[i]+a[j])==n)
                        nTimes++;
                }
            }

        }
        if(nTimes==2)
            return 1;
        else
            return 0;
    }

    public static void main(String[]args){
        int[] arr = {7,3,3,2,4};
        System.out.println(isNUnique(arr,11));
    }
}

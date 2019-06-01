package sample_letf;

public class Example_4 {

    static int[]computeHMS(int seconds){
        int h = seconds/3600;
        int m = seconds%3600/60;
        int s = seconds%60;
        int[]ret = {h,m,s};
        return ret;
    }

    static int isMartian(int[]a){
        if (a==null)
            return 0;
        int num1 = 0;
        int num2 = 0;
        if (a.length==0)
            return 0;
        if (a.length==1){
            if (a[0]==1)
                return 1;
            else
                return 0;
        }
        int value = a[0];
        if (value==1)
            num1++;
        if (value==2)
            num2++;
        for (int i = 1; i < a.length;i++){
            if (a[i]==value)
                return 0;
            else
                value = a[i];

            if (value==1)
                num1++;
            if (value==2)
                num2++;
        }

        if (num1>num2)
            return 1;
        else
            return 0;
    }

    static void printArr(int[]a){
        for (int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }

    }


    static int isPairedN(int[]a,int n){
        if (a == null||a.length<2||n<1||(a.length+a.length-3)<Math.abs(n))
            return 0;

        for (int i = 0;i < a.length;i++){
            for (int j = 0;j < a.length;j++){
                if (i!=j&&i+j==n&&a[i]+a[j]==n)
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[]args){
//        printArr(computeHMS(380));
        int []a = {};
        int n = 0;
        System.out.println(isPairedN(a,n));
    }
}

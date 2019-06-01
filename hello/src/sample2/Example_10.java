package sample2;

public class Example_10 {
    static int findTheBaseInteger(int n,int k){
        if (n<=0||k<0)
            return k;
        int mutiTimes = 0;
        int minDul = Math.abs( k-n*mutiTimes);
        while (Math.abs(k-n*mutiTimes) <= minDul){
            minDul = Math.abs( k-n*mutiTimes);
            mutiTimes++;
        }
        return n*(mutiTimes-1);
    }

    static int isCubePowerful(int n){
        if (n<=0)
            return 0;
        int sum  = 0;
        int num = n;
        while (num>0){
            int x = num%10;
            sum+=x*x*x;
            num/=10;
        }

        if (sum==n)
            return 1;
        else
            return 0;
    }

    static void doItegerBaseRounding(int[]a,int n){
        for (int i = 0;i < a.length;i++){
            a[i] = findTheBaseInteger(n,a[i]);
        }
    }

    static void printArr(int[]arr){
        if (arr==null)
            System.out.println("null");

        for (int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    static int decodeArray(int[]a){
        int factor = a[0]>=0?1 : -1;
        int sum = 0;
        int mutiTimes = 1;
        for (int i = a.length-1;i >= 1;i--){
            sum+=Math.abs(a[i]-a[i-1])*mutiTimes;
            mutiTimes*=10;
        }
        return sum*factor;
    }

    public static void main(String[]args){
        int[]arr = {1,1};
        System.out.println(decodeArray(arr));
    }
}

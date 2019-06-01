package sample3;

public class Example_2 {


    static int isSystematicallyIncreasing(int[]a){
        if (a==null||a.length==0)
            return 0;
        int start = a[0];
        int num = 1;

        for (int i = 0;i < a.length;i+=num++ ){
            start = a[i];
            if (start!=1)
                return 0;
            int index = 0;
            for (int j = i;j < i+num;j++){
                if (a[j]!=start+index++)
                    return 0;
            }
        }
        return 1;
    }

    static boolean isPrime(int n){
        if (n<2)
            return false;
        int half = n/2;
        int start = 2;
        if (half<2)
            return true;
        else{
            while (half>=start){
                if (n%start++==0)
                    return false;
            }
        }
        return true;
    }

    static int factorial(int n){
        if (n==1)
            return 1;
        else
            return n*factorial(n-1);
    }


    static int isFactorialPrime(int n){
        if (!isPrime(n))
            return 0;
        int start = 1;
        while (factorial(start)<n){
            if (factorial(start++)+1==n)
                return 1;
        }
        return 0;
    }

    static int largestDifferenceOfEvens(int[]a){
        if (a==null||a.length<2)
            return -1;

        int evenNum = 0;
        for (int i = 0; i < a.length;i++){
            if (a[i]%2==0)
                evenNum++;
        }

        if (evenNum<2)
            return -1;
        int minEven = Integer.MAX_VALUE,maxEven = Integer.MIN_VALUE;
        for (int i = 0; i < a.length;i++){
            if (a[i]%2==0&&minEven>a[i])
                minEven = a[i];
            if (a[i]%2==0&&maxEven<a[i])
                maxEven = a[i];
        }
        return maxEven-minEven;
    }



    public static void main(String[]args){
        int n = 9;
        for (int i = -(n-1);i <= n-1;i++){
            for (int j = -(n-1);j <= n-1;j++){
                int max = Math.max(Math.abs(i),Math.abs(j));
                System.out.printf("%d  ",max+1);
            }
            System.out.printf("\n");
        }
    }
}

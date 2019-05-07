package mscs.exam;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class FPP {

    public static int isCentered(int[] arr){
        if (arr==null||arr.length%2==0)
            return 0;
        int cIndex = arr.length/2;
        int cValue = arr[cIndex];
        for (int i = 0; i < arr.length; i++) {
            if (i!=cIndex&&arr[i]<=cValue)
                return 0;
        }
        return 1;
    }

    public static int diff(int[] a){
        int oddSum = 0;
        int evenSum = 0;
        if (a==null||a.length==0)
            return oddSum - evenSum;
        for (int i = 0; i < a.length; i++) {
            if (a[i]%2==0)
                evenSum+=a[i];
            else
                oddSum+=a[i];
        }
        return oddSum - evenSum;
    }

    public static char[] subCharArray(char[]a,int start,int len){
        if (a==null||start<0|| len<0|| start+len>a.length)
            return null;
        char[] ret = new char[len];
        for (int i = start,j = 0; i < len; i++,j++) {
            ret[j] = a[i];
        }
        return ret;
    }

    public static int reverseNum(int n){
        int ret = 0;
        int value = 0;
        int sign = n>0?1:-1;
        n*=sign;
        while (n>0){
            value = n%10;
            ret*=10;
            ret+=value;
            n/=10;
        }
        return ret*sign;
    }

    public static int[] commonSub(int[]first,int[]second){
        if (first==null||second==null)
            return null;
        if (first.length==0||second.length==0)
            return new int[0];

        int size = 0;
        int min = first.length>second.length?second.length:first.length;
        int[] temp = new int[min];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i]==second[j]){
                    temp[size++] = first[i];
                }
            }

        }
        int[] retArr = new int[size];
        for (int i = 0; i < size; i++) {
            retArr[i] = temp[i];
        }
        return retArr;
    }

    public static int poe(int[] arr){
        if (arr==null||arr.length<3)
            return -1;
        int i = 0;
        int j = arr.length-1;
        int leftSum = arr[i++];
        int rightSum = arr[j--];
        while (i<j){
            if (leftSum<rightSum){
                leftSum+=arr[i++];
            }else{
                rightSum+=arr[j--];
            }
        }

        if(leftSum==rightSum)
            return i;
        else
            return -1;
    }

    public static int power(int num,int p){
        int ret = 1;
        for (int i = 0; i < p; i++) {
            ret*=num;
        }

        return ret;
    }

    public static int max(int[] arr){
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (ret<arr[i])
                ret = arr[i];
        }
        return ret;
    }

    public static int min(int[] arr){
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (ret>arr[i])
                ret = arr[i];
        }
        return ret;
    }

    public static int fibo(int index){
        int a1 = 1;
        int a2 = 1;
        int sum = 1;
        if (index==1||index==2)
            return 1;
        else{
            for (int i = 0; i < index-2; i++) {
                sum = a1+a2;
                a1 = a2;
                a2 = sum;
            }
        }
        return sum;
    }

    public static int factorialSum(int num){
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= num ; i++) {
            factorial*=i;
            sum+=factorial;
        }
        return sum;
    }

    public static int factorial(int num){
        if (num==1)
            return 1;
        else
            return num*factorial(num-1);
    }

    public static boolean isPrime(int num){
        if (num<2)
            return false;
        else if (num==2)
            return true;
        else {
            if (num%2==0)
                return false;

            for (int i = 3; i*i <= num; i+=2) {
                if (num%i==0)
                    return false;
            }
            return true;
        }
    }

    public static int gcd(int x, int y){
        int z = y;
        while (x%y!=0){
            z = x%y;
            x = y;
            y = z;
        }
        return z;
    }

    public static int gcdRecursion(int x,int y){
        if (y==0)
            return x;
        else
            return gcdRecursion(y,x%y);

    }


    public static int lcm(int x,int y){
        return x*y/gcd(x, y);
    }

    public static String convert(int num,int base){
        String ret = "";
        int sign = num>0?1:-1;
        num = num*sign;
        if (num == 0||base==10)
            return num+"";

        else {
            while (true){
                ret = num%base+ret;
                num/=base;
                if (num>0)
                    ret=","+ret;
                else
                    break;
            }
        }
        String csign = sign>0?"":"-";

        return csign+ret;
    }

    public static int isPerfectSquare(int n){
        int i;
        for (i = 0; i*i <= n; i++) {
            if (i*i==n)
                return 1;
        }
        return 0;
    }

    public static int nextPerfectSquare(int n){
        int num = n+1>0?n+1:0;
        while (true){
            if (isPerfectSquare(num)==1)
                break;
            num++;
        }
        return num;
    }

    public static int primeCount(int start, int end){
        int realStart = start<2?2:start;
        int realEnd = end<2?0:end;
        int num = 0;
        for (int i = realStart; i <= realEnd; i++) {
            if (isPrime(i))
                num++;
        }
        return num;
    }

    public static int isOddsNumber(int n){
        if (n%2==0)
            return 0;
        while (n!=0){
            int ext = n%2;
            if (ext%2==0)
                return 0;
            n/=10;
        }
        return 1;
    }

    public static int isNiceArray(int[] a){
        if (a==null||a.length==0)
            return 0;
        for (int i = 0; i < a.length; i++) {
            if (isPrime(a[i]))
                a[0]-=a[i];
        }

        return 0==a[0]?1:0;
    }

    public static void main(String[]args){
        //Test Here
//        System.out.println(reverseNum(-1234));
//        int[] testArr = new int[]{1,2,3};
//        System.out.println(poe(testArr));
//        System.out.println(power(2,4));
//        System.out.println(min(new int[]{1,3,5,6,4}));
//        for (int i = 1; i < 10; i++) {
//            System.out.print(i+" "+isPrime(i)+"\n");
//        }
//
//        System.out.println(gcdRecursion(30,40));
//        System.out.println(lcm(30,40));
//
//        System.out.println(convert(32,2));
//        System.out.println(isNiceArray(new int[]{13,4,5,5,2,3}));
    }
}

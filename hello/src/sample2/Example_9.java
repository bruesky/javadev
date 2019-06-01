package sample2;

public class Example_9 {


    static boolean isPrime(int n){
        int half = n/2;
        int start  = 2;
        if (half<2)
            return true;

        if (half>=2){
            while (half>=start)
                if (n%start++==0)
                    return false;
        }
        return true;
    }


    static int largestPrimeFactor(int n){
        if (n <2)
            return 0;
        int prime = n;
        while (prime>1){
            if (n%prime==0&&isPrime(prime))
                return prime;
            prime--;
        }
        return prime;
    }

    static int[] encodeNumber(int n){
        if (n<=1)
            return null;

        int startPeime = 2;
        int account = 0;
        int num = n;
        while (num>1){
            if (isPrime(startPeime)&&num%startPeime==0){
                account++;
                num/=startPeime;
            }else {
                startPeime++;
            }
        }
        int[]ret = new int[account];
        startPeime = 2;
        int index = 0;
        num = n;
        while (num>1){
            if (isPrime(startPeime)&&num%startPeime==0){
                ret[index++] = startPeime;
                num/=startPeime;
            }else {
                startPeime++;
            }
        }
        return ret;
    }

    static void printArr(int[]arr){
        if (arr==null) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    static int matchPattern(int[]a,int[]pattern){
        int len = a.length;
        int patternLen = pattern.length;
        int i = 0;
        int k = 0;
        int matches = 0;
        for (i = 0;i < len;i++){
            if (a[i]==pattern[k])
                matches++;
            else if(matches==0 || k == patternLen-1)
                return 0;
            else {
                if (k<patternLen-1){
                    matches = 0;
                    k++;
                    if (a[i]==pattern[k])
                        matches++;
                    else
                        return 0;
                }
            }
        }

        if (i == len && k==patternLen-1)
            return 1;
        else
            return 0;
    }



    public static void main(String[]args){
        int[]a = {1,1,10,2,2,2};
        int[]p = {1,2,3};
        System.out.println(matchPattern(a,p));
//        printArr(encodeNumber(14));
    }
}

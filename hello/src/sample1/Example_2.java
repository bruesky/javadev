package sample1;

public class Example_2 {
    public static boolean isPerfectSquare(int num){
        double f = Math.sqrt(num);
        return f==(int)f;
    }

    public static int countSquarePairs(int[]a){
        if (a==null||a.length<2)
            return 0;
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i!=j&&a[i]>0&&a[j]>0&&a[i]<a[j]){
                    if (isPerfectSquare(a[i]+a[j])){
                        System.out.println(a[i]);
                        System.out.println(a[j]);
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public static int isPrime(int num){
        if (num<2)
            return 0;
        int index = 2;
        while (true){
            if (index>num/2)
                return 1;
            else {
                while (index<=num/2){
                    if(num%(index++)==0)
                        return 0;
                }
                break;
            }
        }
        return 1;
    }

    public static int findPorcupineNumber(int n){
        if (isPrime(n)==1){
            if (n%10!=9)
                return 0;
            while (true){
                if (isPrime(++n)==1){
                    if (n%10==9)
                        return 1;
                    else
                        return 0;
                }
            }
        }else {
            return 0;
        }
    }

    public static int isGuthrieSequence(int []a){
        if(a==null||a.length<2||a[a.length-1]!=1)
            return 0;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]%2==0){
                if (a[i+1]*2!=a[i])
                    return 0;
            }else {
                if (a[i+1]!=a[i]*3+1)
                    return 0;
            }
        }

        return 1;
    }

    public static void main(String args[]){
        int arr[] = {7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1};
        System.out.println(isGuthrieSequence(arr));
    }
}

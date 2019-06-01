package sample1;

public class Example_1 {

    public static int primeCount(int start,int end){
        if(start>end||end<2)
            return 0;
        start = start<2?2:start;
        int num = 0;
        for (int i = start; i <=end ; i++) {
            int index = 2;
            if (i/2<index){
                num++;
            }else {
                boolean bPrime = true;
                while (index<=i/2){
                    if(i%(index++)==0)
                        bPrime = false;
                }
                if(bPrime)
                    num++;
            }
        }
        return num;
    }

    public static int isMadhavArray(int[] a){
        if(a==null||a.length==0)
            return 0;
        int n = 1;
        int length = a.length;
        while (n*(n+1)<length*2){
            n++;
            if (n*(n+1)>length*2)
                return 0;
        }
        int num = 1;
        int start = 0,end = 0;
        int sum = a[0];
        int sum2 = 0;
        while (end<length){
            sum2+=a[start++];
            if(start>end){
                num++;
                end+=num;
                if(sum!=sum2){
                    return 0;
                }else {
                    sum2 = 0;
                }
            }
        }
        return 1;
    }

    public static int isInertial(int[]a){
        if(a==null||a.length<2)
            return 0;
        int max=a[0];
        for (int i = 0; i < a.length; i++) {
            if(max<a[i])
                max = a[i];
        }
        int minOdd = max;

        for (int i = 0; i < a.length; i++) {
            if(minOdd>a[i]&&a[i]%2==1&&a[i]<max)
                minOdd = a[i];
        }

        if (max%2==1)
            return 0;
        if (minOdd%2==0)
            return 0;
        for (int i = 0; i < a.length; i++) {
            if(minOdd<a[i]&&a[i]%2==0&&a[i]<max)
                return 0;
        }

        return 1;
    }




    public static void main(String args[]){
        //Test Here
        int arr[] = {2,1};
        System.out.println(isInertial(arr));
    }
}

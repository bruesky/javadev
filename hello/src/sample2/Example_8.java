package sample2;

public class Example_8 {




    static int largestAdjacementSum(int[]a){
        int[]retArr = new int[a.length/2];
        int index = 0;
        for (int i = 0; i< a.length;i+=2,index++){
            retArr[index] = a[i]+a[i+1];
        }
        int max = retArr[0];
        for (int i = 0;i < retArr.length;i++){
            if (max < retArr[i])
                max = retArr[i];
        }
        return max;
    }

    static int times(int num,int times){
        int base = 10;
        int ret = num;
        while (times>1){
            ret*=base;
            ret+=num;
            times--;
        }
        return ret;
    }

    static int checkConcatenatedSum(int n ,int catlen){
        int sum = 0;
        int num = n;
        while (num>0){
            sum+=times(num%10,catlen);
            num/=10;
        }

        if (n==sum)
            return 1;
        return 0;
    }

    static int isSequencedArray(int[]a,int m,int n){
        if (a==null||a.length==0)
            return 0;
        int value = a[0];
        int num = 1;
        for (int i = 0;i < a.length;i++){
            if (a[i]<m||a[i]>n)
                return 0;
            if (value>a[i])
                return 0;
            else if(value<a[i]){
                value = a[i];
                num++;
            }

        }
        if (num==n-m+1)
            return 1;
        else
            return 0;
    }


    public static void main(String[]args){
        int[]a = {5,4,3,2,1};
        System.out.println(isSequencedArray(a,1,5));
    }
}

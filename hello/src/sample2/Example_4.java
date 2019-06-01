package sample2;

public class Example_4 {

    static int countRepresentations(int numRupees){
        if (numRupees<=0)
            return 0;
        int kind = 0;
        for (int r20 = 0;r20<=numRupees/20;r20++)
            for (int r10 = 0;r10<=numRupees/10;r10++)
                for (int r5 = 0;r5<=numRupees/5;r5++)
                    for (int r2 = 0;r2<=numRupees/2;r2++)
                        for (int r1 = 0;r1<=numRupees;r1++)
                            if (r20*20+r10*10+r5*5+r2*2+r1*1 == numRupees)
                                kind++;
        return kind;
    }

    static int isSequentiallyBounded(int[]a){
        if (a == null)
            return 0;
        if (a.length == 0)
            return 1;
        int value = a[0];
        int num = 0;
        for (int i = 0;i < a.length;i++){
            if (value>a[i])
                return 0;
            else if (value==a[i]){
                num++;
                if(value<=0)
                    return 0;
            }else if(value<a[i]){
                if (value<=num)
                    return 0;
                else {
                    value = a[i];
                    num = 0;
                }
            }
        }
        if (value<=num)
            return 0;
        else
            return 1;
    }

    static int isMinMaxDisjoin(int[]a){
        if (a == null || a.length<3)
            return 0;
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1;i < a.length;i++){
            if (a[minIndex]>a[i])
                minIndex = i;
            if (a[maxIndex]<a[i])
                maxIndex=i;
        }
        if (a[maxIndex]==a[minIndex])
            return 0;
        if (minIndex-maxIndex==1||minIndex-maxIndex==-1)
            return 0;
        int maxTimes = 0;
        int minTimes = 0;
        for (int i = 0;i < a.length;i++){
            if (a[minIndex]==a[i])
                minTimes++;
            if (a[maxIndex]==a[i])
                maxTimes++;
        }
        if (maxTimes>1||minTimes>1)
            return 0;
        return 1;
    }

    public static void main(String[]args){
        int[]arr = {0,5,18,0,9};
        System.out.println(isMinMaxDisjoin(arr));
    }
}

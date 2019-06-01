package slns;

public class Example_3 {

    public static int stantonMeasure(int[] a){
        if(a == null || a.length==0)
            return 0;
        int oneTimes = 0;
        int nTimes = 0;
        for (int i = 0;i < a.length;i++){
            if(a[i]==1){
                oneTimes++;
            }
        }

        for (int i = 0;i < a.length;i++){
            if(a[i]==oneTimes){
                nTimes++;
            }
        }
        return nTimes;
    }

    public static int sumFactor(int[]a){
        if(a == null||a.length==0)
            return 0;
        int sum = a[0];
        for (int i = 1;i < a.length;i++){
            sum+=a[i];
        }
        int sumTimes = 0;
        for (int i = 0;i < a.length;i++){
            if(a[i] == sum)
                sumTimes++;
        }
        return sumTimes;
    }

    public static int guthrieIndex(int n){
        int followNum = 0;
        while (n!=1){
            if(n%2==0)
                n = n/2;
            else
                n = n*3+1;

            followNum++;
        }
        return followNum;
    }




    public static void main(String[] args){
        int[] arr = {3,0,2,-5,0};
        System.out.println(guthrieIndex(42));

    }
}

package sample2;

public class Example_1 {

    public static int isSquare(int n){
        if (n<0)
            return 0;
        int index = 0;
        while (index*index<=n){
            if (index*index==n)
                return 1;
            ++index;
        }
        return 0;
    }

    public static int isLegalNumber(int a[],int base){
        if (a == null||a.length<1||base<2)
            return 0;
        for (int i = 0;i < a.length;i++){
            if(a[i]>=base||a[i]<0)
                return 0;
        }
        return 1;
    }

    public static int convertToBase10(int[]a,int base){
        if (a == null||a.length<1||base<2)
            return -1;
        int sum = 0;
        int bit = 0;
        for (int i = a.length-1;i >= 0;i--){
            if(a[i]>=base||a[i]<0)
                return -1;
            else {
                int tempBit = bit;
                int tempNum = a[i];
                while (tempBit>0) {
                    tempNum *= base;
                    tempBit--;
                }
                sum+=tempNum;
            }
            bit++;
        }

        return sum;
    }
    public static void main(String[] args){
        int[]arr = {1,0,1,1};
        System.out.println(convertToBase10(arr,2));
    }
}

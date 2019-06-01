package slns;

public class Example_4 {

    public static int[] solve10(){
        int x = 1,y = 1;
        int xFac = 1;
        int yFac = 1;
        int tenFac = 1;
        for (int i = 1; i <= 10 ;i++)
            tenFac = tenFac*i;
        System.out.println(tenFac);
        for (int i = 1 ; i < 10;i++){

            xFac = xFac*i;
            System.out.println(xFac);
            x = i;
            y = 1;
            yFac = 1;
            while (yFac<(tenFac-xFac)){
                yFac = yFac*(++y);
//                System.out.printf("%d %d\n",yFac,tenFac-xFac);
            }
//            System.out.println("####");
            if (yFac==(tenFac-xFac))
                break;

        }
        int [] arr = {x,y};
        return arr;
    }

    public static int repsEqual(int[]a,int n){
        if (a == null)
            return 0;
        int sum = 0;
        int bit = 1;
        for (int i = a.length-1;i>=0;i--){
            sum+=(bit*a[i]);
            bit*=10;
        }

        if (n==sum)
            return 1;
        else
            return 0;
    }

    public static int isCentered115(int[]a){
        if (a==null||a.length==0)
            return 0;
        int n = 0;
        int sum = 0;
        while (n<=a.length/2){
            int startIndex = n;
            int endIndex = a.length-n-1;
            sum = 0;
            for (int i = startIndex;i<=endIndex;i++){
                sum+=a[i];
            }
            n++;
            if (sum==15)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        int[]arr = {1,1,8,3,1,1};
        System.out.println(isCentered115(arr));
    }
}

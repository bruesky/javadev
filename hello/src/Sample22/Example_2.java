package Sample22;

public class Example_2 {


    public static int isStacked(int n){
        if (n<1)
            return 0;
        int index = 1;
        int sum = 0;
        while (sum<n){
            sum+=(index++);
            if (sum>n)
                return 0;
        }

        return 1;
    }

    public static int matches(int[]a,int[]b){
        if (a == null||b==null||a.length==0||b.length==0)
            return 0;
        int index = 0;
        for (int i = 0;i < b.length;i++){
            if (b[i]==0)
                return 0;
            if (b[i]>0){
                for (int j = index;j < b[i]+index;j++){
                    if (a[j]<=0)
                        return 0;
                }
                index+=b[i];
            }else if(b[i]<0){
                for (int j = index;j < b[i]*(-1)+index;j++){
                    if (a[j]>=0)
                        return 0;
                }
                index-=b[i];
            }
        }
        return 1;
    }

    public static int isSumSafe(int[]a){
        if (a == null||a.length==0)
            return 0;
        int sum = 0;

        for (int i = 0; i< a.length;i++)
            sum+=a[i];

        for (int i = 0; i < a.length;i++){
            if (a[i] == sum)
                return 0;
        }
        return 1;
    }

    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        double tip = meal_cost*tip_percent/100;
        double tax = meal_cost*tax_percent/100;
        int toatal = (int)Math.round(meal_cost+tip+tax);
        System.out.println(toatal);
    }


    public static void main(String[] args){
        int[]a1 = {5,-2,1};
        int[]a2 = {2,1,-1,-1,2,1};

//        for (int i = 0;i < 20;i++){
//            if (isStacked(i)==1)
//                System.out.println(i);
//        }
        solve(10.25,17,5);
        System.out.println();
    }
}

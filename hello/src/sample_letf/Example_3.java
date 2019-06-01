package sample_letf;

public class Example_3 {


    static int isTriangular(int n){
        if (n<1)
            return 0;
        int start = 1;
        int sum = 0;
        while (n>=sum){
            sum+=start;
            if (sum==n)
                return 1;
            start++;
        }
        return 0;
    }
    

    public static int isMercurial(int[]a){
        if (a==null)
            return 0;

        int left = a.length+1;
        int right = -1;
        for (int i = 0; i < a.length;i++){
            if (a[i]==1){
                if (left>i)
                    left=i;
                if (right<i)
                    right = i;
            }
        }

        if ((left>a.length&&right<0)||left==right)
            return 1;
        for (int i = left;i <= right;i++){
            if (a[i]==3)
                return 0;
        }
        return 1;
    }

    static int is235Array(int[]a){
        int num = 0;
        for (int i = 0; i < a.length;i++){

            if (a[i]%2==0||a[i]%3==0||a[i]%5==0){
                if (a[i]%2==0)
                    num+=1;
                if (a[i]%3==0)
                    num+=1;
                if (a[i]%5==0)
                    num+=1;
            }else
                num+=1;
        }

        if (num==a.length)
            return 1;
        else
            return 0;
    }
    
   

    public static void main(String[]args){

//        for (int i = 1; i < 100;i++){
//            if (isTriangular(i)==1)
//                System.out.println(i);
//        }
//        System.out.println(isTriangular());
        int[]a = {2};
        System.out.println(is235Array(a));

    }
}

package sample_letf;

public class Example_2 {

    static int isVesuvian(int n){
        int s = (int)Math.sqrt(n);
        int s2 = (int)Math.sqrt(n/2);
        int num = 0;
        for (int i = 1;i <= s2;i++){
            for (int j = s2;j <= s;j++){
                if (i*i+j*j == n){
                    num++;
                    System.out.printf("%d %d ",i,j);
                }

            }
        }

        if (num==2)
            return 1;
        else
            return 0;
    }

    static int isOneBalanced(int[]a){
        int num = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < a.length;i++){
            if (a[i]==1)
                left++;
            else
                break;
        }
        for (int i = a.length-1; i >=0;i--){
            if (a[i]==1)
                right++;
            else
                break;
        }

        for (int i = a.length-1; i >=0;i--){
            if (a[i]!=1)
                num++;
        }
        if (left+right==num)
            return 1;
        else
            return 0;
    }

    static int fibonacci(int index){
        if (index==1||index==2)
            return 1;
        int last1 = 1;
        int last2 = 1;
        int start = 2;
        int ret = last1;
        while (index>=++start){
            last2 = last1;
            last1 = ret;
            ret = last1+last2;
        }
        return ret;
    }

    static int isFibonacci(int n){
        int start = 1;
        while (n>=fibonacci(start)){
            if (n==fibonacci(start++))
                return 1;
        }
        return 0;
    }

public static void  main(String[]args){
//    System.out.println(i);
//    int num = 0;
//    for (int i = 0;i < 10000;i++){
//        if (isVesuvian(i)==1){
//            System.out.println(i);
//            num++;
//        }
//
//    }
//
//    System.out.printf("\n\n%d",num);

    int[]a = {1,3,4,1,2,1};
//    System.out.println(isOneBalanced(a));

    for (int i = 1;i < 100;i++){
        if (isFibonacci(i)==1)
            System.out.println(i);

    }
}

}

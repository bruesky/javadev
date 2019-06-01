package sample_letf;

import java.util.HashMap;
import java.util.Map;

public class Example_1 {


    static boolean isPrime(int n){
        if (n < 2)
            return false;
        int half = n/2;
        if (half<2)
            return true;
        else {
            int start = 2;
            while (half>=start){
                if (n%start++==0)
                    return false;
            }
        }
        return true;
    }

    static int isHodder(int n){
        if (!isPrime(n))
            return 0;
        int index = 0;
        int c = 1;
        while (n>(c-1)){
            index++;
            c *=2;
            if (n==(c-1))
                return 1;
        }
        return 0;
    }

    static int areAnagrams(char[]a1,char[]a2){
        if (a1==null||a2==null||a1.length!=a2.length)
            return 0;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0;i < a1.length;i++){
            if (m.containsKey((int)a1[i])){
                int num = m.get((int)a1[i]);
                m.put((int)a1[i],num+1);
            }else {
                m.put((int)a1[i],1);
            }
        }

        for (int i = 0;i < a2.length;i++){
            if (m.containsKey((int)a2[i])){
                int num = m.get((int)a2[i]);
                if (num==0)
                    return 0;
                m.put((int)a2[i],num-1);
            }else
                return 0;
        }
        return 1;
    }

    static int fibonacci(int index){
        if (index==1||index==2)
            return 1;
        else
            return fibonacci(index-1)+fibonacci(index-2);
    }

    static int fibonacci2(int index){
        if (index==1||index==2)
            return 1;
        int last1 = 1;
        int last2 = 1;
        int start = 2;
        int ret = last1;
        while (index>=++start){
            last2 = last1;
            last1 = ret;
            ret = last1 + last2;
        }
        return ret;
    }

    static int closetFibonacci(int n){
        if (n<1)
            return 0;
        int index = 1;
        while (n>=fibonacci2(index))
            index++;
        return fibonacci2(index-1);
    }


    public static void main(String[]args){
//        for (int i = 0; i < 200;i++){
//            if (isHodder(i)==1)
//                System.out.println(i);
//        }
        for (int i = 1; i <11;i++)
            System.out.println(fibonacci2(i));

        char[]a1 = {};
        char[]a2 = {};
        System.out.println(closetFibonacci(34));
    }

}

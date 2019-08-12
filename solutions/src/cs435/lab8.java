package cs435;

public class lab8 {

    public static boolean isPrime(int n){
        if (n<2)
            return false;
        else{
            for (int i = 2; i*i < n; i++) {
                if (n%i==0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[]args){
        for (int i = 0; i < 100; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

}

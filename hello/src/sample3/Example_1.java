package sample3;

public class Example_1 {


    static int isZeroPlentiful(int[]a){
        if (a == null||a.length<4)
            return 0;
        int sNum = 0;
        int zeroNum = 0;
        for (int i = 0;i < a.length;i++){
            if (a[i]==0)
                zeroNum++;
            if (a[i]!=0){
                if (zeroNum>=4){
                    sNum++;
                }else if (zeroNum>0&&zeroNum<4)
                    return 0;
                zeroNum = 0;
            }
        }

        if (zeroNum>=4){
            return ++sNum;
        }else if (zeroNum<4&&zeroNum>0)
            return 0;
        else
            return sNum;
    }

    static int assemble(int digit,int num){
        int sum = 0;
        while (num>0){
            sum*=10;
            sum+=digit;
            num--;
        }
        return sum ;
    }

    static int isDigitIncreasing(int n){
        int digitNum = 0;
        int num = n;
        while (num>0){
            digitNum++;
            num/=10;
        }

        for (int i = 1;i <=9;i++){
            int sum = 0;
            int dn = digitNum;
            while (dn>0){
                sum+=assemble(i,dn--);
            }
            if (sum==n)
                return 1;
        }

        return 0;
    }

    static int encodeArray(int[]a){
//        if (a==null||a.length==0)
          int factor = a[0]==0?1:-1;
          int start = a[0]==0?0:1;
          int zeroNum = 0;
          int sum = 0;

          for (int i = start;i < a.length;i++){
              if (a[i]==0)
                  zeroNum++;
              else{
                  sum*=10;
                  sum+=zeroNum;
                  zeroNum = 0;
              }
          }
          if (zeroNum>0){
              sum*=10;
              sum+=zeroNum;
          }

        return sum*factor;
    }

    static int[] decodeArray(int n){
        int num = Math.abs(n);
        int count = num==0?1:0;
        while (num>0){
            int x = num%10;
            count+=(x+1);
            num/=10;
        }
        if (n<0)
            count+=1;

        int[]ret = new int[count];
        num = Math.abs(n);
        for (int i = count-1;i >=0;i--){
            ret[i] = 1;
            int x = num%10;
            num/=10;
            while (x>0){
                i--;
                ret[i] = 0;
                x--;
            }
        }
        if (n<0)
            ret[0] = -1;
        return ret;
    }

    static void printArr(int[]a){
        for (int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }
    }


    public static void main(String[]args){
        int[]arr = {0,1,1,1,1,1,0,1};
//        System.out.println();
        printArr(decodeArray(0));
    }
}

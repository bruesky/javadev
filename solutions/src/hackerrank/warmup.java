package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class warmup {
    static int sockMerchant(int n, int[] ar) {
        Map<Integer,Integer> socks = new HashMap<>();
        for (int e:
             ar) {
            if (socks.containsKey(e))
                socks.put(e,socks.get(e)+1);
            else
                socks.put(e,1);
        }
        int count = 0;
        for (Map.Entry<Integer,Integer> e:
             socks.entrySet()) {
            count+=e.getValue().intValue()/2;
        }
        return count;
    }

    static int jumpingOnClouds(int[] c) {
        int skip = 0;
        if (c.length<4)
            return 1;
        for (int i = 0; i <= c.length-2;) {
            if (i+2<c.length&&c[i+2]==0)
                i = i+2;
            else if (i+1<c.length&&c[i+1]==0)
                ++i;
            skip++;
        }
        return skip;
    }

    public static void main(String[]args){
        System.out.println(jumpingOnClouds(new int[]{0,0,1,0,0,1,0}));
    }
}

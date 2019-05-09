package mscs.CoreJava.FundamentalProgrammingStructures;

import java.math.BigInteger;

public class Variables {
    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static enum WeekDay { MON, TUE, WED, THU, FRI, SAT, SUN};

    public static void main(String[]args){
        WeekDay startDay = WeekDay.SUN;
        System.out.println(startDay);
        System.out.println(BigInteger.valueOf(23).add(BigInteger.valueOf(34)));
    }

}

package org.xkg.hellojava.Multithreading;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */
public class GarbageCollection {

    public void finalize(){System.out.println("object is garbage collected");}

    public static void main(String[]args){
        Runtime r=Runtime.getRuntime();
        System.out.println("Total Memory: "+r.totalMemory());
        System.out.println("Free Memory: "+r.freeMemory());

        for(int i=0;i<10000;i++){
            new GarbageCollection();
        }
        System.out.println("After creating 10000 instance, Free Memory: "+r.freeMemory());
        System.gc();
        System.out.println("After gc(), Free Memory: "+r.freeMemory());


        GarbageCollection s1=new GarbageCollection();
        GarbageCollection s2=new GarbageCollection();
        s1=null;
        s2=null;
        System.gc();
    }
}

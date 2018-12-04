package org.xkg.hellojava.datastructures;

public class JavaArrayExample {

    /*
    * Java array is an object which contains elements of a similar data type.
    * It is a data structure where we store similar elements. We can store only a fixed set of elements in a Java array.
    * Array in java is index-based, the first element of the array is stored at the 0 index.
    *
    * Code Optimization: It makes the code optimized, we can retrieve or sort the data efficiently.
    * Random access: We can get any data located at an index position.
    * Size Limit: We can store only the fixed size of elements in the array.
    * It doesn't grow its size at runtime. To solve this problem, collection framework is used in Java which grows automatically.
    * */

    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }

    public static void main(String[]args){
        int a[]=new int[5];//declaration and instantiation
        int a1[]={33,3,4,5};//declaration, instantiation and initialization
        printArray(new int[]{10,22,44,66});//passing anonymous array to method

        Class c=a.getClass();
        String name=c.getName();
        //printing the class name of Java array
        System.out.println(name);

    }

}

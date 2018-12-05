package org.xkg.hellojava.datastructures;

public class Stack<T> {
    int top;
    int maxsize = 10;
    T[] arr =  (T[])new Object[maxsize];


    boolean isEmpty()
    {
        return (top < 0);
    }
    Stack()
    {
        top = -1;
    }

    boolean push (T data)
    {
        if(top == maxsize-1)
        {
            System.out.println("Overflow !!");
            return false;
        }
        else
        {
            System.out.println("Enter Value");
            top++;
            arr[top]=data;
            System.out.println("Item pushed");
            return true;
        }
    }
    boolean pop ()
    {
        if (top == -1)
        {
            System.out.println("Underflow !!");
            return false;
        }
        else
        {
            top --;
            System.out.println("Item popped");
            return true;
        }
    }
    void display ()
    {
        System.out.println("Printing stack elements .....");
        for(int i = top; i>=0;i--)
        {
            System.out.println(arr[i]);
        }
    }


    public static void main(String[]args){
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(44);
        stack.display();
    }


}
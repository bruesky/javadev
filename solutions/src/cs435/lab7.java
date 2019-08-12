package cs435;

import java.util.Stack;

public class lab7 {

    public static void reverseStr(String string){
        Stack<Character> stack = new Stack<>();
        for (Character c:
             string.toCharArray()) {
            stack.push(c);
        }
        while (!stack.empty()){
            System.out.printf("%c",stack.peek());
            stack.pop();
        }
    }

    public static void main(String[]args){
        reverseStr("hello world");
    }
}

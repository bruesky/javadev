package org.xkg.hellojava.basics;

public class Statement {
    public Statement() {
    }

    public void play(){
        int marks=65;

        if(marks<50){
            System.out.println("fail");
        }
        else if(marks>=50 && marks<60){
            System.out.println("D grade");
        }
        else if(marks>=60 && marks<70){
            System.out.println("C grade");
        }
        else if(marks>=70 && marks<80){
            System.out.println("B grade");
        }
        else if(marks>=80 && marks<90){
            System.out.println("A grade");
        }else if(marks>=90 && marks<100){
            System.out.println("A+ grade");
        }else{
            System.out.println("Invalid!");
        }

        //Creating two variables for age and weight
        int age=20;
        int weight=80;
        //applying condition on age and weight
        if(age>=18){
            if(weight>50){
                System.out.println("You are eligible to donate blood");
            }
        }

        //The switch statement works with byte, short, int, long, enum types,
        // String and some wrapper types like Byte, Short, Int, and Long.

        //Code of Java for loop
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }

        //Declaring an array
        int arr[]={12,23,44,56,78};
        //Printing array using for-each loop
        for(int i:arr){
            System.out.println(i);
        }

/*
        for(;;){
            System.out.println("infinitive loop");
        }
*/

        //Java While Loop

        int i=1;
        while(i<=10){
            System.out.println(i);
            i++;
        }
        //Java Do While Loop
        i=1;
        do{
            System.out.println(i);
            i++;
        }while(i<=10);


        //for loop
        for(i=1;i<=10;i++){
            if(i==5){
                //using continue statement
                continue;//it will skip the rest statement
            }
            System.out.println(i);
        }
    }


    public static void main(String[]args){
        Statement statement = new Statement();
        statement.play();
    }
}

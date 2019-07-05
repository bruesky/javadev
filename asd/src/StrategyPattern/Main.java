package StrategyPattern;
//Strategy

//Defines a family of algorithms that are each encapsulated as objects,
//and can be selected dynamically at runtime

//Implement a class’ method in different ways

//Method-dedicated Object
//Delegation to a Polymorphic Structure

//https://en.wikipedia.org/wiki/Software_design_pattern
//https://en.wikipedia.org/wiki/Strategy_pattern
public class Main {
    private OperationStrategy operationStrategy;

    public Double doOperation(double a, double b){
        return operationStrategy.exec(a,b);
    }


    public static void main(String[]args){
        Main main = new Main();
        main.operationStrategy = new AddStrategy();
        System.out.println(main.doOperation(4,6));
        main.operationStrategy = new MultiplicationStrategy();
        System.out.println(main.doOperation(4,6));
    }

}

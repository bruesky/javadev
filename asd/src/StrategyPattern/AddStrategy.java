package StrategyPattern;

public class AddStrategy implements OperationStrategy {
    @Override
    public Double exec(Double a, Double b) {
        return a+b;
    }
}

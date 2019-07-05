package StrategyPattern;

public class MultiplicationStrategy implements OperationStrategy {
    @Override
    public Double exec(Double a, Double b) {
        return a*b;
    }
}

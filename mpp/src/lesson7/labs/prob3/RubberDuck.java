package lesson7.labs.prob3;

public class RubberDuck extends Duck implements CannotFly,Squeak{
    public RubberDuck() {

    }

    @Override
    public void fly() {
        CannotFly.super.fly();
    }

    @Override
    public void quack() {
        Squeak.super.quack();
    }
}

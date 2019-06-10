package lesson7.labs.prob3;

public class MallardDuck extends Duck implements FlyWithWings,Quack {
    public MallardDuck() {
    }

    @Override
    public void display() {
        System.out.println("display");
    }

    @Override
    public void fly() {
        FlyWithWings.super.fly();
    }

    @Override
    public void quack() {
        Quack.super.quack();
    }
}

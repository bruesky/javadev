package lesson7.labs.prob3;

import lesson4.lecture.staticinherit.second.Super;

public class RedheadDuck extends Duck implements  FlyWithWings,Quack {
    public RedheadDuck() {

    }

    @Override
    public void quack() {
        FlyWithWings.super.fly();
    }

    @Override
    public void fly() {
        Quack.super.quack();
    }
}

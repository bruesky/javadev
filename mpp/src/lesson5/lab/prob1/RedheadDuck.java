package lesson5.lab.prob1;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        setFlyBehavior(BehaviorFactory.getFlyBehaviorByName("FlyWithWings"));
        setQuackBehavior(BehaviorFactory.getQuackBehaviorByName("Quack"));
    }
}

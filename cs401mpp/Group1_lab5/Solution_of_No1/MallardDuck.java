package lesson5.lab.prob1;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(BehaviorFactory.getFlyBehaviorByName("FlyWithWings"));
        setQuackBehavior(BehaviorFactory.getQuackBehaviorByName("Quack"));
    }

    @Override
    public void display() {
        System.out.println("display");
    }
}

package lesson5.lab.prob1;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(BehaviorFactory.getFlyBehaviorByName("CannotFly"));
        setQuackBehavior(BehaviorFactory.getQuackBehaviorByName("Squeak"));
    }
}

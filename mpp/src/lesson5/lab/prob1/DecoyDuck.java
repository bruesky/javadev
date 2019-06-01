package lesson5.lab.prob1;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(BehaviorFactory.getFlyBehaviorByName("CannotFly"));
        setQuackBehavior(BehaviorFactory.getQuackBehaviorByName("MuteQuack"));
    }
}

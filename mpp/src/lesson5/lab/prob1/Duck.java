package lesson5.lab.prob1;

public class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void quack(){
        this.quackBehavior.quack();
    }

    public void fly(){
        this.flyBehavior.fly();
    }

    public void swim(){
        System.out.println("swimming");
    }

    public void display(){
        System.out.println("displaying");
    }
}

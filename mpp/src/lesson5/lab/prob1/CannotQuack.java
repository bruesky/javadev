package lesson5.lab.prob1;

public class CannotQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("cannot quack");
    }
}

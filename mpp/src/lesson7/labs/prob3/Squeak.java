package lesson7.labs.prob3;

public interface Squeak {
    default void quack() {
        System.out.println("squeaking");
    }
}

package lesson5.lab.prob1;

public class BehaviorFactory {
    public static FlyBehavior getFlyBehaviorByName(String name){
        name = "lesson5.lab.prob1."+name;
        Object o = null;
        try {
            o = Class.forName(name).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (FlyBehavior) o;
    }

    public static QuackBehavior getQuackBehaviorByName(String name){
        name = "lesson5.lab.prob1."+name;
        Object o = null;
        try {
            o = Class.forName(name).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (QuackBehavior) o;
    }
}

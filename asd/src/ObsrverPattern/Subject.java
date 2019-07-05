package ObsrverPattern;

import java.util.List;

public interface Subject {
    List<Observer> getAll();

    default void addOberver(Observer o){
        getAll().add(o);
    }

    default void notifyAllObservers(){
        for (Observer o:
             getAll()) {
            o.update();
        }
    }
}

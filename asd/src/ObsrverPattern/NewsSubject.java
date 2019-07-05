package ObsrverPattern;

import java.util.ArrayList;
import java.util.List;

public class NewsSubject implements Subject {
    private List<Observer> list = new ArrayList<>();
    @Override
    public List<Observer> getAll() {
        return list;
    }
}

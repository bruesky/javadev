package CommandPattern;

import java.util.List;

public class Actor {
    public void execAction(Action action){
        action.doAction();
    }
}

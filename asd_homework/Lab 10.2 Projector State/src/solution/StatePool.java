package solution;
import java.util.*;

public class StatePool {
    private static Map<StateEnum,List<State>> map = new HashMap<>();
    public static State getState(StateEnum stateEnum){
        if (map.containsKey(stateEnum)){
            List<State> list = map.get(stateEnum);
            for (State s:
                 list) {
                if (!s.isbBusy())
                    return s;
            }
            State state = newState(stateEnum);
            list.add(state);
            return state;
        }else {
            List<State> list = new LinkedList<>();
            State state = newState(stateEnum);
            list.add(state);
            map.put(stateEnum,list);
            return state;
        }
    }

    public static State newState(StateEnum stateEnum){
        State state = null;
        switch (stateEnum){
            case SUSPENDED:
                state = new SuspendedState();
                break;

            case COOLINGOFF:
                state = new CoolingOffState();
                break;

            case PROJECTING:
                state = new ProjectingState();
                break;

        }
        return state;
    }

}

package solution;

public class CoolingOffState extends State {
    @Override
    public void onEntry(ProjectorMachine projectorMachine) {
        super.onEntry(projectorMachine);
        System.out.println("entry / lamp off");
    }

    @Override
    public void doWhileInState() {
        System.out.println("do / fan boost");
    }

    @Override
    public void handleEvent(InputEvent inputEvent) {
        switch (inputEvent){
            case NORMAL_TEMP:
                switchState(StatePool.getState(StateEnum.SUSPENDED));
        }
    }
}

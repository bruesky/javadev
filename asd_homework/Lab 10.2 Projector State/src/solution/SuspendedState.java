package solution;

public class SuspendedState extends State {


    @Override
    public void onEntry(ProjectorMachine projectorMachine) {
        super.onEntry(projectorMachine);
        System.out.println("entry /"+getProjectorMachine().indicator.yellow());
    }

    @Override
    public void doWhileInState() {
        System.out.println("do /"+getProjectorMachine().indicator.blink());
    }

    @Override
    public void handleEvent(InputEvent inputEvent) {
        switch (inputEvent){
            case POWER_ON:
                switchState(StatePool.getState(StateEnum.PROJECTING));
        }
    }
}

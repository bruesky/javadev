package solution;

public class ProjectingState extends State {
    @Override
    public void onEntry(ProjectorMachine projectorMachine) {
        super.onEntry(projectorMachine);
        System.out.println("entry /"+getProjectorMachine().indicator.green());
        System.out.println("entry / lamp on");
    }

    @Override
    public void doWhileInState() {
        System.out.println("do / project singnal");
    }

    @Override
    public void handleEvent(InputEvent inputEvent) {
        switch (inputEvent){
            case STOP:
                getProjectorMachine().indicator.blue();
                switchState(StatePool.getState(StateEnum.COOLINGOFF));
                break;

            case HIGH_TEMP:
                getProjectorMachine().indicator.red();
                switchState(StatePool.getState(StateEnum.COOLINGOFF));
                break;

        }
    }
}

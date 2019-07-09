package solution;

public abstract class State {
    private ProjectorMachine projectorMachine = null;

    public boolean isbBusy() {
        return projectorMachine!=null;
    }

    public ProjectorMachine getProjectorMachine() {
        return projectorMachine;
    }

    public void setProjectorMachine(ProjectorMachine projectorMachine) {
        this.projectorMachine = projectorMachine;
    }

    public void switchState(State state){
        projectorMachine.switchState(state);
    }

    public void onEntry(ProjectorMachine projectorMachine) {
        System.out.println("Entering " + getClass().getSimpleName());
        setProjectorMachine(projectorMachine);
    }
    public abstract void doWhileInState();

    public void onExit() {
        System.out.println("Exiting " + getClass().getSimpleName());
        System.out.println();
        setProjectorMachine(null);
    }
    public abstract void handleEvent(InputEvent inputEvent);
}

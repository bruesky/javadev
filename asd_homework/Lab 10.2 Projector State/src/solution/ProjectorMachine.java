package solution;

public class ProjectorMachine {
    private State state = null;
    Indicator indicator;

    public ProjectorMachine() {
        indicator = new Indicator();
    }

    public void start(){
        switchState(StatePool.getState(StateEnum.SUSPENDED));
    }

    public void end(){
        this.state.onExit();
        this.state = null;
    }

    public void input(InputEvent inputEvent){
        this.state.handleEvent(inputEvent);
    }

    public void switchState(State state){
        if (this.state!=null)
            this.state.onExit();
        this.state = state;
        this.state.onEntry(this);
        this.state.doWhileInState();
    }

}

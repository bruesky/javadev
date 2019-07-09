package solution;

public class App {

    public static void main(String[]args){
        ProjectorMachine projectorMachine = new ProjectorMachine();
        projectorMachine.start();

        projectorMachine.input(InputEvent.POWER_ON);
        projectorMachine.input(InputEvent.HIGH_TEMP);
//        projectorMachine.input(InputEvent.STOP);


        projectorMachine.input(InputEvent.NORMAL_TEMP);
        projectorMachine.end();
    }
}

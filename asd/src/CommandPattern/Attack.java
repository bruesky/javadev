package CommandPattern;

public class Attack implements Action {
    @Override
    public void doAction() {
        System.out.println("attack");
    }

    @Override
    public void undoAction() {
        System.out.println("undo attack");
    }
}

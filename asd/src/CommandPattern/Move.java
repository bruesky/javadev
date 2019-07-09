package CommandPattern;

public class Move implements Action {
    @Override
    public void doAction() {
        System.out.println("move");
    }

    @Override
    public void undoAction() {
        System.out.println("undo move");
    }
}

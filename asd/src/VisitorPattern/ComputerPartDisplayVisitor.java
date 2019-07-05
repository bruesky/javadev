package VisitorPattern;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("visit Computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("visit Keyboard");

    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit Mouse");

    }
}

package VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerPart {
    private List<ComputerPart> list = new ArrayList<>();

    public Computer() {
        list.add(new Keyboard());
        list.add(new Mouse());
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart c:
             list) {
            c.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

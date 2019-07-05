package BridgePattern;

public class Line implements Item {
    @Override
    public void drawBlack() {
        System.out.println("Line drawBlack");
    }

    @Override
    public void drawBlue() {
        System.out.println("Line drawBlue");
    }

    @Override
    public void drawRed() {
        System.out.println("Line drawRed");

    }
}

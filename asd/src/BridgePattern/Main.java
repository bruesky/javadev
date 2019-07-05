package BridgePattern;

public class Main {
    public static void main(String[] args){
        Item item = new Line();
        Shape shape = new Shape(item);
        shape.draw();
    }
}

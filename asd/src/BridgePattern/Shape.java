package BridgePattern;

public class Shape {
    private Item item;

    public Shape(Item item) {
        this.item = item;
    }

    public void draw(){
        if (item!=null){
            item.drawRed();
            item.drawBlack();
            item.drawBlue();
        }
    }
}

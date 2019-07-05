package FacadePatern;

public class ShapeFacade {
    private Shape line;
    private Shape rect;
    private Shape circle;
    public ShapeFacade() {
        line = new Line();
        circle = new Circle();
        rect = new Rect();
    }

    public void drawLine(){
        line.draw();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRect(){
        rect.draw();
    }

    public static void main(String[]args){
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCircle();
        shapeFacade.drawLine();
        shapeFacade.drawRect();
    }


}

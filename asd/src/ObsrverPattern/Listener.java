package ObsrverPattern;

public class Listener implements Observer {
    private String name;

    public Listener(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(name+" update");
    }
}

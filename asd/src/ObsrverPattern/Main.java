package ObsrverPattern;

public class Main {
    public static void main(String[]args){
        Subject subject = new NewsSubject();
        Observer o1 = new Listener("Jon");
        Observer o2 = new Listener("Lee");
        Observer o3 = new Listener("Guo");

        subject.addOberver(o1);
        subject.addOberver(o2);
        subject.addOberver(o3);

        subject.notifyAllObservers();
    }
}

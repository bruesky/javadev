package CommandPattern;

public class Main {
    public static void main(String[]args){
        Action move = new Move();
        Action attack = new Attack();

        Actor actor = new Actor();
        actor.execAction(move);
        actor.execAction(attack);
    }
}

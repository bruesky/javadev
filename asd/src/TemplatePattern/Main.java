package TemplatePattern;

public class Main {
    public static void main(String[]args){
        Game game = new BasketballGame();
        game.play();

        game = new PingpongGame();
        game.play();
    }
}

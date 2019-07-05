package AdaptorPattern;

public class Main {
    public static void main(String[]args) throws ClassNotFoundException {
        VideoPlayer mp4 = new MP4();
        MusicPlayer mp3 = new MP3();

        AllPurposeMachine allPurposeMachine = new AllPurposeMachine();
        allPurposeMachine.play(mp3);
        allPurposeMachine.play(mp4);
    }
}

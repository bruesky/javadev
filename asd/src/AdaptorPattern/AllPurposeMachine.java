package AdaptorPattern;

public class AllPurposeMachine {
    void play(Object player) throws ClassNotFoundException {
        if (player.getClass()==Class.forName("AdaptorPattern.MP3"))
            ((MusicPlayer)player).playMP3();
        else if (player.getClass().toString().contains("AdaptorPattern.MP4"))
            ((VideoPlayer)player).playMP4();
    }
}

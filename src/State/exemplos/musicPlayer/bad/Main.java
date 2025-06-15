package State.exemplos.musicPlayer.bad;

public class Main {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.pause();
        musicPlayer.stop();
        musicPlayer.play();
        musicPlayer.pause();
    }
}

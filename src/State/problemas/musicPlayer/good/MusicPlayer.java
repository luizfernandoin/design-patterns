package State.problemas.musicPlayer.good;

public class MusicPlayer {
    private EstadosPlayer estadosPlayer;

    public MusicPlayer() {
        this.estadosPlayer = new Parado();
    }

    public void setEstadosPlayer(EstadosPlayer estadosPlayer) {
        this.estadosPlayer = estadosPlayer;
    }

    public void play() {
        this.estadosPlayer = estadosPlayer.play();
        System.out.println(this.getEstadosPlayer());
    }

    public void pause() {
        this.estadosPlayer = estadosPlayer.pause();
        System.out.println(this.getEstadosPlayer());
    }

    public void stop() {
        this.estadosPlayer = estadosPlayer.stop();
        System.out.println(this.getEstadosPlayer());
    }

    public String getEstadosPlayer() {
        return estadosPlayer.toString();
    }
}

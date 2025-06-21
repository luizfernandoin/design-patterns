package State.problemas.musicPlayer.good;

public interface EstadosPlayer {
    public Tocando play();
    public EstadosPlayer pause();
    public Parado stop();
}

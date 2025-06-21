package State.problemas.musicPlayer.bad;

public class MusicPlayer {
    private EstadoPlayer estadoPlayer;

    public MusicPlayer() {
        this.estadoPlayer = EstadoPlayer.PARADO;
    }

    public void play() {
        if (estadoPlayer == EstadoPlayer.TOCANDO) {
            System.out.println("Já está tocando!");
        } else {
            System.out.println(estadoPlayer == EstadoPlayer.PAUSADO ? "Retomando a música" : "Iniciando a música...");
        }
    }

    public void pause() {
        if (estadoPlayer == EstadoPlayer.TOCANDO) {
            System.out.println("Pausando a música...");
            estadoPlayer = EstadoPlayer.PAUSADO;
        } else if (estadoPlayer == EstadoPlayer.PAUSADO) {
            System.out.println("A música já está pausada.");
        } else {
            System.out.println("Não é possível pausar. A música está parada.");
        }
    }

    public void stop() {
        if (estadoPlayer == EstadoPlayer.PARADO) {
            System.out.println("A música já está parada.");
        } else {
            System.out.println("Parando a música...");
            estadoPlayer = EstadoPlayer.PARADO;
        }
    }
}

package State.problemas.musicPlayer.good;

public class Parado implements EstadosPlayer {
    @Override
    public Tocando play() {
        System.out.println("Iniciando a música...");
        return new Tocando();
    }

    @Override
    public EstadosPlayer pause() {
        System.out.println("Não é possível pausar. A música está parada.");
        return new Parado();
    }

    @Override
    public Parado stop() {
        System.out.println("A música já está parada.");

        return new Parado();
    }
}

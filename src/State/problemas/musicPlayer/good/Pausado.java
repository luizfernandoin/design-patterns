package State.problemas.musicPlayer.good;

public class Pausado implements EstadosPlayer{
    @Override
    public Tocando play() {
        System.out.println("Retomando a música...");
        return new Tocando();
    }

    @Override
    public Pausado pause() {
        System.out.println("A música já está pausada.");
        return new Pausado();
    }

    @Override
    public Parado stop() {
        System.out.println("Parando a música...");
        return new Parado();
    }
}

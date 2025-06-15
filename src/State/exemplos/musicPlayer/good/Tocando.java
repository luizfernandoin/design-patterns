package State.exemplos.musicPlayer.good;

public class Tocando implements EstadosPlayer{
    @Override
    public Tocando play() {
        System.out.println("Já está tocando!");
        return new Tocando();
    }

    @Override
    public Pausado pause() {
        System.out.println("Pausando a música...");
        return new Pausado();
    }

    @Override
    public Parado stop() {
        System.out.println("Parando a música...");
        return new Parado();
    }
}

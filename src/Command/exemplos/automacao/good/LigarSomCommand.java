package Command.exemplos.automacao.good;

import Command.exemplos.automacao.good.Dispositivos.Som;

public class LigarSomCommand implements Command {
    Som som;
    int volume;

    public LigarSomCommand(Som som, int volume) {
        this.som = som;
        this.volume = volume;
    }

    @Override
    public void executar() {
        som.ligar(volume);
    }
}

package Command.problemas.automacao.good;

import Command.problemas.automacao.good.Dispositivos.Som;

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

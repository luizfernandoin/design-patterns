package Command.problemas.automacao.good;


import Command.problemas.automacao.good.Dispositivos.TV;

public class LigarTVCommand implements Command {
    TV tv;
    int volume;

    public LigarTVCommand(TV tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void executar() {
        tv.ligar(volume);
    }
}

package Command.exemplos.automacao.good;


import Command.exemplos.automacao.good.Dispositivos.TV;

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

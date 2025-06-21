package Command.problemas.automacao.good;

import Command.problemas.automacao.good.Dispositivos.ArCondicionado;

public class LigarArCommand implements Command {
    ArCondicionado arCondicionado;
    int temperatura;

    public LigarArCommand(ArCondicionado arCondicionado, int temperatura) {
        this.arCondicionado = arCondicionado;
        this.temperatura = temperatura;
    }

    @Override
    public void executar() {
        arCondicionado.ligar(this.temperatura);
    }
}

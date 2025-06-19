package Command.exemplos.automacao.good;

import Command.exemplos.automacao.good.Dispositivos.ArCondicionado;
import Command.exemplos.automacao.good.Dispositivos.Som;
import Command.exemplos.automacao.good.Dispositivos.TV;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Som som = new Som();
        ArCondicionado arCondicionado = new ArCondicionado();

        LigarTVCommand ligarTVCommand = new LigarTVCommand(tv, 10);
        LigarSomCommand ligarSomCommand = new LigarSomCommand(som, 10);
        LigarArCommand ligarArCommand = new LigarArCommand(arCondicionado, 20);

        ligarArCommand.executar();
    }
}

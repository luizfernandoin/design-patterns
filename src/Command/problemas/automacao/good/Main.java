package Command.problemas.automacao.good;

import Command.problemas.automacao.good.Dispositivos.ArCondicionado;
import Command.problemas.automacao.good.Dispositivos.Som;
import Command.problemas.automacao.good.Dispositivos.TV;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Command> historicoComandos = new ArrayList<>();

        TV tv = new TV();
        Som som = new Som();
        ArCondicionado arCondicionado = new ArCondicionado();

        LigarTVCommand ligarTVCommand = new LigarTVCommand(tv, 10);
        LigarSomCommand ligarSomCommand = new LigarSomCommand(som, 10);
        LigarArCommand ligarArCommand = new LigarArCommand(arCondicionado, 20);

        ligarArCommand.executar();
    }
}

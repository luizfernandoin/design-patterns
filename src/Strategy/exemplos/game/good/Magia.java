package Strategy.exemplos.game.good;

public class Magia implements Ataque{
    @Override
    public void atacar() {
        System.out.println("Atacando com magia!");
    }
}

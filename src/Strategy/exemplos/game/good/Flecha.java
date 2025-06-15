package Strategy.exemplos.game.good;

public class Flecha implements Ataque{
    @Override
    public void atacar() {
        System.out.println("Atacando com flecha!");
    }
}

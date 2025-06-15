package Strategy.exemplos.game.bad;

public class Personagem {
    public void Atacar(TiposAtaque tiposAtaque) {
        switch (tiposAtaque) {
            case Espada:
                System.out.println("Atacando com Espada!");
                break;
            case Magia:
                System.out.println("Atacando com magia!");
                break;
            case Flecha:
                System.out.println("Atacando com flecha!");
                break;
            default:
                throw new IllegalArgumentException("Tipo de ataque desconhecido!");
        }
    }
}

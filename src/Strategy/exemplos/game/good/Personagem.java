package Strategy.exemplos.game.good;

public class Personagem {
    private Ataque ataque;

    public Personagem(Ataque tipoAtaque) {
        this.ataque = tipoAtaque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public void atacar() {
        this.ataque.atacar();
    }
}

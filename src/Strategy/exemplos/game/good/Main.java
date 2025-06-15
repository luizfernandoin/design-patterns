package Strategy.exemplos.game.good;


public class Main {
    public static void main(String[] args) {
        Personagem personagem = new Personagem(new Flecha());
        personagem.atacar();

        personagem.setAtaque(new Espada());
        personagem.atacar();

        personagem.setAtaque(new Magia());
        personagem.atacar();
    }
}

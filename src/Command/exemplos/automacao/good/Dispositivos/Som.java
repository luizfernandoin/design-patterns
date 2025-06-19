package Command.exemplos.automacao.good.Dispositivos;

public class Som {
    private boolean estaLigado = false;
    private int volume;

    public void ligar(int volume) {
        this.volume = volume;
        this.estaLigado = true;
        System.out.println("Ligando som...");
    }

    public void desligar() {
        this.estaLigado = false;
        System.out.println("Desligando som...");
    }
}

package Command.exemplos.automacao.good.Dispositivos;

public class TV {
    private int volume;
    private boolean estaLigado;

    public void ligar(int volume) {
        this.estaLigado = true;
        this.volume = volume;
        System.out.println("Ligando TV...");
    }

    public void desligar() {
        this.estaLigado = false;
        System.out.println("Desligando TV...");
    }
}

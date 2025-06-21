package Command.problemas.automacao.good.Dispositivos;

public class ArCondicionado {
    private int temperatura;
    private boolean estaLigado = false;

    public void ligar(int temperatura) {
        this.estaLigado = true;
        this.temperatura = temperatura;
        System.out.println("Ligando ar condicionado na temperatura: " + this.temperatura);
    }

    public void desligar() {
        this.estaLigado = false;
        System.out.println("Desligando ar condicionado...");
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isEstaLigado() {
        return estaLigado;
    }
}

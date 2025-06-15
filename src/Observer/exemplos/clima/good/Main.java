package Observer.exemplos.clima.good;

public class Main {
    public static void main(String[] args) {
        Clima clima = new Clima(EstadoClima.ENSOLARADO);
        Painel painel = new Painel();

        clima.adicionarObserver(painel);
        clima.mandarAlerta("Use protetor solar!");
        Painel painel1 = new Painel();
        clima.adicionarObserver(painel1);
        clima.mandarAlerta("Clima ensolarado ainda!");
    }
}

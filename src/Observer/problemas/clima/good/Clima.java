package Observer.problemas.clima.good;

import java.util.ArrayList;
import java.util.List;

public class Clima {
    private List<Observer> observers = new ArrayList<>();
    private EstadoClima estadoClima;

    public Clima(EstadoClima estadoClima) {
        this.estadoClima = estadoClima;
    }

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    };

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void mandarAlerta(String mensagem) {
        for (Observer o : observers) {
            o.notificar(estadoClima, mensagem);
        }
    }
}

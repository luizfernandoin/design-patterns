package Observer.problemas.good;

import java.util.ArrayList;
import java.util.List;

public class AreaDeNotificacao {
    private List<Observer> apps = new ArrayList<>();

    public void registrar(Observer o) {
        apps.add(o);
    }

    public void remover(Observer o) {
        apps.remove(o);
    }

    public void novaNotificacao(String mensagem) {
        for (Observer o : apps) {
            o.notificar(mensagem);
        }
    }

}

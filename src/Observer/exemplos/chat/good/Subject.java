package Observer.exemplos.chat.good;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    public void adicionarObserver(Observer observer);
    public void removerObserver(Observer observer);
    public void notificarObservers(String mensagem, String remetente);
}

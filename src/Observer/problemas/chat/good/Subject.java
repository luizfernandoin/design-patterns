package Observer.problemas.chat.good;

public interface Subject {
    public void adicionarObserver(Observer observer);
    public void removerObserver(Observer observer);
    public void notificarObservers(String mensagem, String remetente);
}

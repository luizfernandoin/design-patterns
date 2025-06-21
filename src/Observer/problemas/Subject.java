package Observer.problemas;

public interface Subject {
    void add(Observer o);
    void remove(Observer o);
    void notificar();
}

package Observer.exemplos.chat.good;

import java.util.ArrayList;
import java.util.List;

public class Chat implements Subject {
    String nome;
    List<Usuario> admins = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();

    public Chat(String nome, Usuario admin) {
        this.nome = nome;
        this.admins.add(admin);
        this.observers.add(admin);
    }

    public boolean userIsAdmin(Usuario usuario) {
        return admins.stream()
                .anyMatch(admin -> admin.getId().equals(usuario.getId()));
    }

    public void adicionarAdmin(Usuario admin, Usuario novoAdmin) {
        admins.add(novoAdmin);
        observers.add(novoAdmin);
        notificarObservers(admin.getNome() + " adicionou " + novoAdmin.getNome() + " como admin!", admin.getNome());
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(String mensagem, String remetente) {
        for (Observer observer : observers) {
            observer.receberMensagem(mensagem, remetente);
        }
    }

    public void enviarMensagem(String mensagem, String remetente) {
        notificarObservers(mensagem, remetente);
    }
}

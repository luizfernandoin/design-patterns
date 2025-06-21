package Observer.problemas.good;

public class Email implements Observer {
    @Override
    public void notificar(String mensagem) {
        System.out.println("Email: " + mensagem);
    }
}

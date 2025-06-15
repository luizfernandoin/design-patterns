package Observer.good;

public class WhatsApp implements Observer {
    @Override
    public void notificar(String mensagem) {
        System.out.println("WhatsApp: " + mensagem);
    }
}

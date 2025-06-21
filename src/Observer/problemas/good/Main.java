package Observer.problemas.good;

public class Main {
    public static void main(String[] args) {
        AreaDeNotificacao areaDeNotificacao = new AreaDeNotificacao();

        WhatsApp whats = new WhatsApp();
        Email email = new Email();

        areaDeNotificacao.registrar(whats);
        areaDeNotificacao.registrar(email);

        areaDeNotificacao.novaNotificacao("Enviando notificação!");
    }
}

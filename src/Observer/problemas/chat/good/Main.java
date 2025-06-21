package Observer.problemas.chat.good;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Luiz Fernando");
        Chat chat = new Chat("Revoada Intelectual", usuario);
        usuario.setChat(chat);

        Usuario usuario1 = new Usuario("Ana");
        chat.adicionarObserver(usuario1);

        Usuario usuario2 = new Usuario("Luiza");
        chat.adicionarAdmin(usuario, usuario2);

        chat.enviarMensagem("Oi", usuario1.getNome());
    }
}

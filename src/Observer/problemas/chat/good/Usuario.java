package Observer.problemas.chat.good;

import java.util.UUID;

public class Usuario implements Observer {
    private UUID id;
    private String nome;
    private Chat chat;

    public Usuario(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    @Override
    public void receberMensagem(String mensagem, String remetente) {
        if (!remetente.equals(this.nome)) {
            System.out.println(remetente + " -> " + mensagem);
        }
    }

    public void sair() {
        chat.removerObserver(this);
        chat.notificarObservers(this.nome + " saiu do chat!", this.nome);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}

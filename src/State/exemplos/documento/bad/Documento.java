package State.exemplos.documento.bad;

public class Documento {
    private EstadoDocumento state;

    public Documento(EstadoDocumento state) {
        this.state = state;
    }

    public void publicar() {
        this.state = switch (this.state) {
            case RASCUNHO -> EstadoDocumento.MODERAÇÃO;
            case MODERAÇÃO -> EstadoDocumento.PUBLICADO;
            case PUBLICADO -> this.state;
        };
    }
}

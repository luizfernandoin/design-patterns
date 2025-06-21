package State.problemas.documento.good;

public class Documento {
    private EstadoDocumento state = new DocumentoEstadoRascunho();

    public Documento(EstadoDocumento state) {
        this.state = state;
    }

    public void publicar() {
        this.state.publicar();
    }
}
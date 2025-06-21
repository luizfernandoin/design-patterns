package State.problemas.documento.good;

public class DocumentoEstadoPublicado implements EstadoDocumento {
    @Override
    public EstadoDocumento publicar() {
        return new DocumentoEstadoPublicado();
    }
}

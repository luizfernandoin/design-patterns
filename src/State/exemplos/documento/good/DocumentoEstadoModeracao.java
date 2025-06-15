package State.exemplos.documento.good;

public class DocumentoEstadoModeracao implements EstadoDocumento {
    @Override
    public EstadoDocumento publicar() {
        return new DocumentoEstadoPublicado();
    }
}

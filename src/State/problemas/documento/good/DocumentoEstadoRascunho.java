package State.problemas.documento.good;

public class DocumentoEstadoRascunho implements EstadoDocumento {

    @Override
    public EstadoDocumento publicar() {
        return new DocumentoEstadoModeracao();
    }
}

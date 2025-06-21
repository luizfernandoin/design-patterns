package Observer.problemas.clima.good;

public interface Observer {
    public void notificar(EstadoClima estadoClima, String mensagem);
}

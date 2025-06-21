package Observer.problemas.clima.good;

public class Painel implements Observer {
    @Override
    public void notificar(EstadoClima estadoClima, String mensagem) {
        System.out.println(mensagem + estadoClima );
    }
}

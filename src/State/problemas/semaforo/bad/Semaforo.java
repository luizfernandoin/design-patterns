package State.problemas.semaforo.bad;

public class Semaforo {
    private EstadoSemaforo estadoSemaforo;

    public Semaforo(EstadoSemaforo estadoSemaforo) {
        this.estadoSemaforo = estadoSemaforo;
    }

    public void mudar() {
        this.estadoSemaforo = switch (this.estadoSemaforo) {
            case VERDE -> EstadoSemaforo.AMARELO;
            case AMARELO -> EstadoSemaforo.VERMELHO;
            case VERMELHO -> EstadoSemaforo.VERDE;
        };
    }

    public EstadoSemaforo getEstadoSemaforo() {
        return this.estadoSemaforo;
    }
}

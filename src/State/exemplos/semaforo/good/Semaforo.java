package State.exemplos.semaforo.good;

public class Semaforo {
    private EstadoSemaforo state;

    public Semaforo(EstadoSemaforo state) {
        this.state = state;
    }

    public void setState(EstadoSemaforo state) {
        this.state = state;
    }

    public void mudar() {
        this.state = state.mudar();
    }

    public void mostrarCor() {
        this.state.mostrarCor();
    }
}
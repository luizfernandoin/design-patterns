package State.problemas.semaforo.good;

public class Vermelho implements EstadoSemaforo {
    @Override
    public void mostrarCor() {
        System.out.println("VERMELHO - PARE!");
    }

    @Override
    public Verde mudar() {
        return new Verde();
    }
}
package State.exemplos.semaforo.good;

public class Verde implements EstadoSemaforo {
    @Override
    public void mostrarCor() {
        System.out.println("VERDE - PODE PASSAR!");
    }

    @Override
    public Amarelo mudar() {
        return new Amarelo();
    }
}
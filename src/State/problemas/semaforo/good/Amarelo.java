package State.problemas.semaforo.good;

public class Amarelo implements EstadoSemaforo {
    @Override
    public void mostrarCor() {
        System.out.println("AMARELO - ATENÇÃO!");
    }

    @Override
    public Vermelho mudar() {
        return new Vermelho();
    }
}
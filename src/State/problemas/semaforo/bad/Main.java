package State.problemas.semaforo.bad;

public class Main {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo(EstadoSemaforo.VERDE);

        semaforo.mudar();
        System.out.println(semaforo.getEstadoSemaforo());
    }
}

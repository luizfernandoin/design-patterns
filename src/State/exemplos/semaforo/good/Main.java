package State.exemplos.semaforo.good;


public class Main {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo(new Verde());
        semaforo.mostrarCor();

        semaforo.mudar();
        semaforo.mostrarCor();

        semaforo.mudar();
        semaforo.mostrarCor();
    }
}

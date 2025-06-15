package State.exemplos.lampada.bad;

public class Main {
    public static void main(String[] args) {
        Lampada lampada = new Lampada();
        System.out.println("Lampada " + lampada.getEstadoLampada());

        lampada.acionar();
        System.out.println("Lampada " + lampada.getEstadoLampada());

        lampada.acionar();
        System.out.println("Lampada " + lampada.getEstadoLampada());
    }
}

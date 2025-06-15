package State.exemplos.lampada.bad;

public class Lampada {
    private EstadoLampada estadoLampada = EstadoLampada.DESLIGADA;

    public void acionar() {
        this.estadoLampada = switch (this.estadoLampada) {
            case LIGADA -> EstadoLampada.DESLIGADA;
            case DESLIGADA -> EstadoLampada.LIGADA;
        };
    }

    public EstadoLampada getEstadoLampada() {
        return estadoLampada;
    }
}

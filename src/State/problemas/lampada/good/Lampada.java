package State.problemas.lampada.good;

import State.problemas.lampada.bad.EstadoLampada;

public class Lampada {
    private EstadoLampada state;

    public EstadoLampada getState() {
        return state;
    }

    public void setState(EstadoLampada state) {
        this.state = state;
    }
}

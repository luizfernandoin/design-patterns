package State.exemplos.lampada.good;

import State.exemplos.lampada.bad.EstadoLampada;

public class Lampada {
    private EstadoLampada state;

    public EstadoLampada getState() {
        return state;
    }

    public void setState(EstadoLampada state) {
        this.state = state;
    }
}

package GRASP.LowCoupling.bad;

public class Traveler {
    private Car carro = new Car();

    public Car getCarro() {
        return carro;
    }

    public void setCarro(Car carro) {
        this.carro = carro;
    }
}

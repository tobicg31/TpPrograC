package tripulantes.decorator;

/**
 * Esta clase representa un decorador concreto por origen, en este caso,
 * un tripulante que se origine de Vulcano.
 */
public class Vulcano extends DecoratorLiquidacion {
    public Vulcano(Liquidable liquidable) {
        super.setLiquidable(liquidable);
        this.subsidioPorOrigen = 30;
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes() + " |Por origen Vulcano:" + this.subsidioPorOrigen
                + " |Total:" + this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes() + this.subsidioPorOrigen;
    }

}

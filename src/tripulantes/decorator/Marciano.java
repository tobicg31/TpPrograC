package tripulantes.decorator;

public class Marciano extends DecoratorLiquidacion {
    public Marciano(Liquidable liquidable) {
        super.setLiquidable(liquidable);
        this.subsidioPorOrigen = 18;
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes() + " |Por origen Marciano:" + this.subsidioPorOrigen
                + " |Total:" + this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes() + this.subsidioPorOrigen;
    }

}

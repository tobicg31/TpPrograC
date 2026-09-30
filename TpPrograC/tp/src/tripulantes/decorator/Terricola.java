package tripulantes.decorator;

public class Terricola extends DecoratorLiquidacion {
    public Terricola(Liquidable liquidable) {
        super.setLiquidable(liquidable);
        this.subsidioPorOrigen = 20;
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes() + " |Por origen Terricola:" + this.subsidioPorOrigen
                + " |Total:" + this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes() + this.subsidioPorOrigen;
    }

}

package tripulantes.decorator;

public abstract class DecoratorLiquidacion implements Liquidable {
    protected Liquidable liquidable;
    protected double subsidioPorOrigen;

    public Liquidable getLiquidable() {
        return liquidable;
    }

    public void setLiquidable(Liquidable liquidable) {
        this.liquidable = liquidable;
    }
}

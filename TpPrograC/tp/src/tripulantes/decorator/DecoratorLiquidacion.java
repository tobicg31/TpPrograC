package tripulantes/decorator;

public abstract class DecoratorLiquidacion implements Liquidable {
    private Liquidable liquidable;
    
    public Liquidable getLiquidable() {
        return liquidable;
    }

    public void setLiquidable(Liquidable liquidable) {
        this.liquidable = liquidable;
    }
}

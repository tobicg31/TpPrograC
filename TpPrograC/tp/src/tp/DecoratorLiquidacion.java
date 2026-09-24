
package tp;


public abstract class DecoratorLiquidacion implements Liquidable {
    private Liquidable liquidable;
//reescribo tripulante.descripcionHaberes y lo transformo en abstracto
    public Liquidable getLiquidable() {
        return liquidable;
    }

    public void setLiquidable(Liquidable liquidable) {
        this.liquidable = liquidable;
    }
}

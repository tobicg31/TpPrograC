package tripulantes.decorator;

/**
 * Esta clase representa la abstracción de una decoración en base al
 * origen del tripulante.
 */
public abstract class DecoratorLiquidacion implements Liquidable {
    protected Liquidable liquidable;
    protected double subsidioPorOrigen;

    public Liquidable getLiquidable() {
        return liquidable;
    }

    /**
     * Establece el objeto Liquidable que será decorado.
     * 
     * <b>PRE:</b>
     * - liquidable != null
     * 
     * @param liquidable El objeto Liquidable que se desea decorar.
     */
    public void setLiquidable(Liquidable liquidable) {
        assert liquidable != null : "El objeto Liquidable no puede ser nulo.";
        this.liquidable = liquidable;
    }
}

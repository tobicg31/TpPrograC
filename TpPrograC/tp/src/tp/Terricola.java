
package tp;

public class Terricola extends DecoratorLiquidacion {
    public Terricola(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Terricola:"+this.getLiquidacionPorOrigen()+" |Total:"+this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes()+getLiquidacionPorOrigen();
    }

    private double getLiquidacionPorOrigen() {
        return 20;
    }

}

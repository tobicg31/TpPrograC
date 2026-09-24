
package tp;

public class Terricola extends DecoratorLiquidacion {
    public Terricola(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Terricola:"+this.getliquidacionpororigen()+" |Total:"+this.liquidaciondeHaberes();
    }

    @Override
    public double liquidaciondeHaberes() {
        return super.getLiquidable().liquidaciondeHaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 20;
    }

}

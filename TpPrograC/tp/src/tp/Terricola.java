
package tp;

public class Terricola extends DecoratorLiquidacion {
    public Terricola(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionhaberes() {
        return super.getLiquidable().descripcionhaberes()+" |Por origen Terricola:"+this.getliquidacionpororigen()+" |Total:"+this.liquidaciondehaberes();
    }

    @Override
    public double liquidaciondehaberes() {
        return super.getLiquidable().liquidaciondehaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 20;
    }

}

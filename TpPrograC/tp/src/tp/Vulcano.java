
package tp;

public class Vulcano extends DecoratorLiquidacion {
    public Vulcano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionhaberes() {
        return super.getLiquidable().descripcionhaberes()+" |Por origen Vulcano:"+this.getliquidacionpororigen()+" |Total:"+this.liquidaciondehaberes();
    }

    @Override
    public double liquidaciondehaberes() {
        return super.getLiquidable().liquidaciondehaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 30;
    }

}


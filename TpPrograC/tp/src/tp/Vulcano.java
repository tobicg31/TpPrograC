
package tp;

public class Vulcano extends DecoratorLiquidacion {
    public Vulcano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Vulcano:"+this.getliquidacionpororigen()+" |Total:"+this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 30;
    }

}


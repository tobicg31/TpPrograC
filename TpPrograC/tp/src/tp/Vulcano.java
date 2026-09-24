
package tp;

public class Vulcano extends DecoratorLiquidacion {
    public Vulcano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Vulcano:"+this.getLiquidacionPorOrigen()+" |Total:"+this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes()+getLiquidacionPorOrigen();
    }

    private double getLiquidacionPorOrigen() {
        return 30;
    }

}


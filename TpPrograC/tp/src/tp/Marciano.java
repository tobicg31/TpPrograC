package tp;

public class Marciano extends DecoratorLiquidacion{
    public Marciano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Marciano:"+this.getLiquidacionPorOrigen()+" |Total:"+this.liquidacionDeHaberes();
    }

    @Override
    public double liquidacionDeHaberes() {
        return super.getLiquidable().liquidacionDeHaberes()+getLiquidacionPorOrigen();
    }

    private double getLiquidacionPorOrigen() {
        return 18;
    }

}


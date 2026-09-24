package tp;

public class Marciano extends DecoratorLiquidacion{
    public Marciano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionHaberes() {
        return super.getLiquidable().descripcionHaberes()+" |Por origen Marciano:"+this.getliquidacionpororigen()+" |Total:"+this.liquidaciondeHaberes();
    }

    @Override
    public double liquidaciondeHaberes() {
        return super.getLiquidable().liquidaciondeHaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 18;
    }

}


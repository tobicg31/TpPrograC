package tp;

public class Marciano extends DecoratorLiquidacion{
    public Marciano(Liquidable liquidable){
        super.setLiquidable(liquidable);
    }

    @Override
    public String descripcionhaberes() {
        return super.getLiquidable().descripcionhaberes()+" |Por origen Marciano:"+this.getliquidacionpororigen()+" |Total:"+this.liquidaciondehaberes();
    }

    @Override
    public double liquidaciondehaberes() {
        return super.getLiquidable().liquidaciondehaberes()+getliquidacionpororigen();
    }

    private double getliquidacionpororigen() {
        return 18;
    }

}


package tp;

public class Capitan extends Tripulante {
    

    public Capitan(String id,String cargo,int antiguedad,double porcent, String planeta) {
        super(id,"Capitan",antiguedad,0.2, planeta);
    }

    @Override
    public double liquidacionPorCargo(){
        return 1000;

    }
    @Override
    public String descripcionHaberes(){
        return ("Correspondiente al cargo Capitan:"+this.liquidacionPorCargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidacionDeHaberes(){
        return this.liquidacionPorCargo()+this.getliquidacionporantiguedad();
    }
}
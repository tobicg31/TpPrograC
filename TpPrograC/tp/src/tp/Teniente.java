package tp;

public class Teniente extends Tripulante {
    public Teniente(String id,String cargo,int antiguedad,double porcent, String planeta) {
        super(id,"Teniente",antiguedad,0.03, planeta);
    }
    

    @Override
    public double liquidacionPorCargo(){
        return 400;
    }
    @Override
    public String descripcionHaberes(){
        return ("Correspondiente al cargo Teniente:"+this.liquidacionPorCargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidaciondeHaberes(){
        return this.liquidacionPorCargo()+this.getliquidacionporantiguedad();
    }
}
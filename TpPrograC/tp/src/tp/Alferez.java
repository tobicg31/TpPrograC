package tp;

public class Alferez extends Tripulante {
    public Alferez(String id,String cargo,int antiguedad,double porcent, String planeta) {
        super(id,"Alferez",antiguedad,0.005, planeta);
    }
    
    @Override
    public double liquidacionPorCargo(){
        return 200;

    }
    @Override
    public String descripcionHaberes(){
        return ("Correspondiente al cargo Alferez:"+this.liquidacionPorCargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidaciondeHaberes(){
        return this.liquidacionPorCargo()+this.getliquidacionporantiguedad();
    }
}

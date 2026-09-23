package tp;

public class Alferez extends Tripulante {
    public Alferez(String id,String cargo,int antiguedad,double porcent) {
        super(id,"Alferez",antiguedad,0.5/100);
    }
    
    @Override
    public double liquidacionporcargo(){
        return 200;

    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo Alferez:"+this.liquidacionporcargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidaciondehaberes(){
        return this.liquidacionporcargo()+this.getliquidacionporantiguedad();
    }
}

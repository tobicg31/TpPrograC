package tp;

public class Teniente extends Tripulante {
    public Teniente(String id,String cargo,int antiguedad,double porcent) {
        super(id,"Teniente",antiguedad,3/100);
    }
    

    @Override
    public double liquidacionporcargo(){
        return 400;
    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo Teniente:"+this.liquidacionporcargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidaciondehaberes(){
        return this.liquidacionporcargo()+this.getliquidacionporantiguedad();
    }
}
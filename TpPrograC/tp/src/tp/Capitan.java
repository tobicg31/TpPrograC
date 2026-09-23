package tp;

public class Capitan extends Tripulante {
    

    public Capitan(String id,String cargo,int antiguedad,double porcent) {
        super(id,"Capitan",antiguedad,20/100);
    }

    @Override
    public double liquidacionporcargo(){
        return 1000;

    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo Capitan:"+this.liquidacionporcargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad());

    }
    @Override
    public double liquidaciondehaberes(){
        return this.liquidacionporcargo()+this.getliquidacionporantiguedad();
    }
}
package tp;

public class Consejero extends Tripulante {
    private int cantidadconsejos=0;
   // private int cantidadconsejos; ???
    public Consejero(String id,String cargo,int antiguedad,double porcent) {
        super(id,"Consejero",antiguedad,5/100);
    }
  
   @Override
    public double liquidacionporcargo(){
        return 600;
    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo Consejero:"+this.liquidacionporcargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad()+" |Por ser Consejero:"+this.getliquidacionporcantconsejos());

    }
    @Override
    public double liquidaciondehaberes(){
        return this.liquidacionporcargo()+this.getliquidacionporantiguedad()+this.getliquidacionporcantconsejos();
    }

    public int getCantidadconsejos() {
        return cantidadconsejos;
    }

    public void addCantidadconsejos(int cantidadconsejos) {
        this.cantidadconsejos+= cantidadconsejos;
    }
    public double getliquidacionporcantconsejos(){
        return 2*this.cantidadconsejos;
    }
}

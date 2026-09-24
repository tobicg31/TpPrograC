package tp;

public class Consejero extends Tripulante {
    private int cantidadConsejos=0;
   
    public Consejero(String id,String cargo,int antiguedad,double porcent, String planeta) {
        super(id,"Consejero",antiguedad,0.05, planeta);
    }
   @Override
    public double liquidacionPorCargo(){
        return 600;
    }
    @Override
    public String descripcionHaberes(){
        return ("Correspondiente al cargo Consejero:"+this.liquidacionPorCargo()+" |Por antiguedad:"+this.getliquidacionporantiguedad()+" |Por ser Consejero:"+this.getLiquidacionPorCantConsejos());

    }
    @Override
    public double liquidacionDeHaberes(){
        return this.liquidacionPorCargo()+this.getliquidacionporantiguedad()+this.getLiquidacionPorCantConsejos();
    }

    public int getCantidadConsejos() {
        return cantidadConsejos;
    }

    public void addCantidadConsejos(int cantidadConsejos) {
        this.cantidadConsejos+= cantidadConsejos;
    }
    public double getLiquidacionPorCantConsejos(){
        return 2*this.cantidadConsejos;
    }
}

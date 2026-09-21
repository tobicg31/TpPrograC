package tp;


public class AdicionalAntiguedad extends DecoratorLiquidacion {
    private Tripulante tripulante;

    public AdicionalAntiguedad(Tripulante t){
        if (t==null){
            throw new IllegalArgumentException("El tripulante no puede ser nulo");
        }
        this.tripulante=t;
    }
    public double getmontoadicional(){
       return (tripulante.porcentadicional*tripulante.liquidaciondehaberes())*tripulante.antiguedad;
    }
    @Override
    public double liquidaciondehaberes(){
        return tripulante.liquidaciondehaberes()+this.getmontoadicional();
    }
    @Override
   public String descripcionhaberes(){
        return (tripulante.descripcionhaberes()+"|Adicional por cada año de antiguedad:"+this.getmontoadicional());

   } 

}

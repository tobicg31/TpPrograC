package tp;

public abstract class Tripulante implements Liquidable {
    protected  String identidad, cargo;
    protected int antiguedad;
    protected double porcentadicional;
    
    public Tripulante(String id,String cargo,int antiguedad,double porcent) {
        this.identidad=id;
        this.cargo=cargo;
        this.antiguedad=antiguedad;
        this.porcentadicional=porcent;
    }

    public String getIdentidad() {
        return identidad;
    }

    public String getCargo() {
        return cargo;
    }
    public int getAntiguedad() {
        return antiguedad;
    }

    protected double getliquidacionporantiguedad(){ /*Para que lo hereden tranquilamente todos sus hijos */
        return (this.porcentadicional*this.liquidaciondehaberes())*this.antiguedad;
    }
    public abstract double liquidacionporcargo();
}


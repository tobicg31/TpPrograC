package tp;

public abstract class Tripulante implements Liquidable {
    protected  String identidad, cargo, planeta;
    protected int antiguedad;
    protected double porcentAdicional;
    
    public Tripulante(String id,String cargo,int antiguedad,double porcent, String planeta) {
        this.identidad=id;
        this.cargo=cargo;
        this.antiguedad=antiguedad;
        this.porcentAdicional=porcent;
        this.planeta=planeta;
    }

    public String getIdentidad() {
        return identidad;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPlaneta() {
        return planeta;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    protected double getliquidacionporantiguedad(){ /*Para que lo hereden tranquilamente todos sus hijos */
        return (this.porcentAdicional*this.liquidacionPorCargo())*this.antiguedad;
    }
    public abstract double liquidacionPorCargo();
}


package tp;

public abstract class Tripulante {
    protected  String identidad, cargo, planeta;
    protected int antiguedad;
    protected double porcentadicional;
    
    public Tripulante() {
       super();
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

    public String tooString(){
        return (this.identidad+": Cargo:"+this.cargo+" |Planeta:"+this.planeta+" |Antiguedad:"+this.antiguedad);
        
    }

    //voy con metodo para decorator, el resultado deberá informar el total y mantener identificable el aporte de cada concepto.
    public abstract double liquidaciondehaberes();
    public abstract  String descripcionhaberes();
    
}


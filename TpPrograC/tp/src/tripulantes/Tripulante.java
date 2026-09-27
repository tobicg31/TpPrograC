package tripulantes;

import tripulantes.decorator.Liquidable;

public abstract class Tripulante implements Liquidable {
    protected String identidad, cargo, planeta;
    protected int antiguedad;
    protected double porcentAdicional;

    public Tripulante(String identidad, String cargo, int antiguedad, double porcentAdicional, String planeta) {
        this.identidad = identidad;
        this.cargo = cargo;
        this.antiguedad = antiguedad;
        this.porcentAdicional = porcentAdicional;
        this.planeta = planeta;
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

    public abstract double liquidacionPorCargo();

    /**
     * Método que calcula la parte de la liquidación correspondiente a la antigüedad
     * del tripulante.
     *
     * @return La liquidación por antigüedad.
     */
    protected double liquidacionPorAntiguedad() {
        return (this.porcentAdicional * this.liquidacionPorCargo()) * this.antiguedad;
    }

}

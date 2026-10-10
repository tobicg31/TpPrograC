package tripulantes;

import tripulantes.decorator.Liquidable;

public abstract class Tripulante implements Liquidable {
    protected String identidad, cargo, planeta;
    protected int antiguedad;
    protected double porcentAdicional;

    /**
     * Constructor de la clase Tripulante.
     * <b>PRE:</b>
     * - identidad != null && !identidad.isEmpty()
     * - cargo != null && !cargo.isEmpty()
     * - antiguedad >= 0
     * - porcentAdicional >= 0
     * - planeta != null && !planeta.isEmpty()
     * 
     * @param identidad        Nombre del tripulante.
     * @param cargo            Cargo del tripulante, puede ser: Capitan, Alferez,
     *                         Consejero ó Teniente.
     * @param antiguedad       Años de antigüedad del tripulante.
     * @param porcentAdicional Porcentaje adicional que se aplica a la liquidación
     *                         por antigüedad. No puede ser vacío.
     * @param planeta          Planeta de origen del tripulante, puede ser:
     *                         Terricola, Vulcano ó Marciano.
     */
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
     * @return Devuelve la liquidación por antigüedad.
     */
    protected double liquidacionPorAntiguedad() {
        return (this.porcentAdicional * this.liquidacionPorCargo()) * this.antiguedad;
    }

}

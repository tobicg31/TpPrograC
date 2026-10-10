package tripulantes;

import tripulantes.decorator.Liquidable;

/**
 * Esta clase representa la abstracción de los Tripulantes abordo de la nave.
 *  
 * <b>Invariantes de clase:</b>
 * - identidad luego de la inicialización.
 * - porcentAdicional >= 0
 * - antiguedad >= 0
 * 
 */
public abstract class Tripulante implements Liquidable {
    protected String identidad, cargo, planeta;
    protected int antiguedad;
    protected double porcentAdicional;

    protected boolean invariante() {
        return this.porcentAdicional >= 0 && this.antiguedad >= 0;
    }
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
        assert identidad != null && !identidad.isEmpty() : "La identidad no puede ser nula o vacía";
        assert cargo != null && !cargo.isEmpty() : "El cargo no puede ser nulo o vacío";
        assert antiguedad >= 0 : "La antigüedad no puede ser negativa";
        assert porcentAdicional >= 0 : "El porcentaje adicional no puede ser negativo";
        assert planeta != null && !planeta.isEmpty() : "El planeta no puede ser nulo o vacío";
        this.identidad = identidad;
        this.cargo = cargo;
        this.antiguedad = antiguedad;
        this.porcentAdicional = porcentAdicional;
        this.planeta = planeta;
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
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

    /**
     * Método abstracto que calcula la liquidación correspondiente al cargo del
     * tripulante.
     *
     * @return Devuelve la liquidación por cargo.
     */
    public abstract double liquidacionPorCargo();

    /**
     * Método que calcula la parte de la liquidación correspondiente a la antigüedad
     * del tripulante.
     *
     * @return Devuelve la liquidación por antigüedad.
     */
    protected double liquidacionPorAntiguedad() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return (this.porcentAdicional * this.liquidacionPorCargo()) * this.antiguedad;
    }

}

package tripulantes;

/**
 * Esta clase representa un tipo concreto de Tripulante abordo de la nave,
 * en este caso un Capitan.
 */
public class Capitan extends Tripulante {

    public Capitan(String id, String cargo, int antiguedad, double porcent, String planeta) {
        super(id, "Capitan", antiguedad, 0.2, planeta);
    }

    @Override
    public double liquidacionPorCargo() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return 1000;

    }

    @Override
    public String descripcionHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return ("Correspondiente al cargo Capitan:" + this.liquidacionPorCargo() + " |Por antiguedad:"
                + this.liquidacionPorAntiguedad());

    }

    @Override
    public double liquidacionDeHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return this.liquidacionPorCargo() + this.liquidacionPorAntiguedad();
    }
}
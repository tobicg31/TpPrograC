package tripulantes;

/**
 * Esta clase representa un tipo concreto de Tripulante abordo de la nave,
 * en este caso un Teniente.
 */
public class Teniente extends Tripulante {
    public Teniente(String id, String cargo, int antiguedad, double porcent, String planeta) {
        super(id, "Teniente", antiguedad, 0.03, planeta);
    }

    @Override
    public double liquidacionPorCargo() {
        assert invariante()
                : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return 400;
    }

    @Override
    public String descripcionHaberes() {
        assert invariante()
                : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return ("Correspondiente al cargo Teniente:" + this.liquidacionPorCargo() + " |Por antiguedad:"
                + this.liquidacionPorAntiguedad());

    }

    @Override
    public double liquidacionDeHaberes() {
        assert invariante()
                : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return this.liquidacionPorCargo() + this.liquidacionPorAntiguedad();
    }
}
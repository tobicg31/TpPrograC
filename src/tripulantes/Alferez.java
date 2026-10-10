package tripulantes;

/**
 * Esta clase representa un tipo concreto de Tripulante abordo de la nave,
 * en este caso un Alferez.
 */
public class Alferez extends Tripulante {

    public Alferez(String id, String cargo, int antiguedad, double porcent, String planeta) {
        super(id, "Alferez", antiguedad, 0.005, planeta);
    }

    @Override
    public double liquidacionPorCargo() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return 200;
    }

    @Override
    public String descripcionHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return ("Correspondiente al cargo Alferez:" + this.liquidacionPorCargo() + " |Por antiguedad:"
                + this.liquidacionPorAntiguedad());

    }

    @Override
    public double liquidacionDeHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return this.liquidacionPorCargo() + this.liquidacionPorAntiguedad();
    }
}

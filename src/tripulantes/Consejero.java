package tripulantes;

/**
 * Esta clase representa un tipo concreto de Tripulante abordo de la nave,
 * en este caso un Consejero.
 */
public class Consejero extends Tripulante {
    private int cantidadConsejos = 0;

    public Consejero(String id, String cargo, int antiguedad, double porcent, String planeta) {
        super(id, "Consejero", antiguedad, 0.05, planeta);
    }

    @Override
    public double liquidacionPorCargo() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return 600;
    }

    @Override
    public String descripcionHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return ("Correspondiente al cargo Consejero:" + this.liquidacionPorCargo() + " |Por antiguedad:"
                + this.liquidacionPorAntiguedad() + " |Por ser Consejero:" + this.getLiquidacionPorCantConsejos());

    }

    @Override
    public double liquidacionDeHaberes() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return this.liquidacionPorCargo() + this.liquidacionPorAntiguedad() + this.getLiquidacionPorCantConsejos();
    }

    public int getCantidadConsejos() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return cantidadConsejos;
    }

    public void addCantidadConsejos(int cantidadConsejos) {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        this.cantidadConsejos += cantidadConsejos;
    }

    public double getLiquidacionPorCantConsejos() {
        assert invariante() : "Invariante de clase violada: porcentAdicional y antiguedad deben ser mayores o iguales a 0";
        return 2 * this.cantidadConsejos;
    }
}

package asistentes;

import bitacoras.Bitacora;
import misiones.Mision;
import misiones.excepciones.NaveSinRecursosException;
import naves.Nave;

public class Asistente {
    private Nave nave;
    private Bitacora bitacora;

    public Asistente(Nave n) {
        this.nave = n;
        this.bitacora = new Bitacora();
    }

    public Nave getNave() {
        return nave;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave asociada al asistente.
     * @param mision Este parámetro representa la misión que se desea ejecutar, no puede ser nulo.
     * @return Registra en la bitácora el resultado de la ejecución de la misión.
     */
    public void ejecutarMision(Mision mision) {

        try {
            mision.ejecutarMision(this.nave);
            this.bitacora.agregarEntrada("Mision " + mision.getNombreMision() + " ejecutada con exito", "INFO");
        } catch (NaveSinRecursosException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(), "ERROR");
        }
    }

}

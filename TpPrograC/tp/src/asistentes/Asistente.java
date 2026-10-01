package asistentes;

import bitacoras.Bitacora;
import misiones.Mision;
import misiones.excepciones.NaveSinRecursosException;
import misiones.excepciones.NaveMantenimientoException;
import naves.Nave;

public class Asistente {
    private Nave nave;
    private Bitacora bitacora;

    /**
     * Constructor de la clase Asistente.
     * @param n Este parámetro representa la nave que se desea asociar al asistente, no puede ser nulo.
     */
    public Asistente() {
        this.bitacora = new Bitacora();
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void hacerMantenimiento(Nave nave){
        nave.setDesgaste(0);
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave asociada al asistente.
     * @param mision Este parámetro representa la misión que se desea ejecutar, no puede ser nulo.
     * @return Registra en la bitácora el resultado de la ejecución de la misión.
     */
    public void ejecutarMision(Mision mision, Nave nave) {

        try {
            mision.setAsistente(this);
            mision.ejecutarMision(nave);
            this.bitacora.agregarEntrada("Mision " + mision.getNombreMision() + " ejecutada con exito", "INFO");
        } catch (NaveSinRecursosException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(), "ERROR");
        } catch (NaveMantenimientoException e){
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(), "ERROR");
        }
    }

    public void consultarBitacora() {
        this.bitacora.consultarBitacora();
    }
}

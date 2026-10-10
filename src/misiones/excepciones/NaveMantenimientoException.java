package misiones.excepciones;

/**
 * Esta clase representa la excepción que se lanza cuando una nave requeire
 * mantenimiento.
 */
public class NaveMantenimientoException extends Exception {

    /**
     * Constructor de la clase NaveMantenimientoException.
     * <b>PRE:</b>
     * - m != null && !m.isEmpty()
     * 
     * @param m Mensaje de error.
     */
    public NaveMantenimientoException(String m) {
        assert m != null && !m.isEmpty() : "El mensaje de error no puede ser nulo o vacío";
        super(m);
    }

    public NaveMantenimientoException() {
        super("La nave requiere mantenimiento");
    }
}

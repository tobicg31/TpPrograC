package misiones.excepciones;

public class NaveMantenimientoException extends Exception {

    /**
     * Constructor de la clase NaveMantenimientoException.
     * <b>PRE:</b>
     * - m != null && !m.isEmpty()
     * 
     * @param m Mensaje de error.
     */
    public NaveMantenimientoException(String m) {
        super(m);
    }

    public NaveMantenimientoException() {
        super("La nave requiere mantenimiento");
    }
}

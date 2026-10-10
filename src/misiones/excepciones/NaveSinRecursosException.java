package misiones.excepciones;

/**
 * Esta clase representa la excepción que se lanza cuando una nave no tiene
 * los recursos necesarios para realizar una misión.
 */
public class NaveSinRecursosException extends Exception {

    /**
     * Constructor de la clase NaveSinRecursosException.
     * <b>PRE:</b>
     * - m != null && !m.isEmpty()
     * 
     * @param m Mensaje de error.
     */
    public NaveSinRecursosException(String m) {
        assert m != null && !m.isEmpty() : "El mensaje de error no puede ser nulo o vacío";
        super(m);
    }

    public NaveSinRecursosException() {
        super("Fallo de recursos");
    }
}

package misiones.excepciones;

public class NaveSinRecursosException extends Exception {

    /**
     * Constructor de la clase NaveSinRecursosException.
     * <b>PRE:</b>
     * - m != null && !m.isEmpty()
     * 
     * @param m Mensaje de error.
     */
    public NaveSinRecursosException(String m) {
        super(m);
    }

    public NaveSinRecursosException() {
        super("Fallo de recursos");
    }
}

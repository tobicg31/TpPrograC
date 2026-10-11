package naves.state;

/**
 * Esta interface define el comportamiento de los diferentes estados del motor
 * de una nave. Cada estado implementará estas acciones de manera específica
 * según su lógica.
 */
public interface MotorState{
    void prepararSalto() throws TransicionErroneaException ;

    void saltar() throws TransicionErroneaException ;

    void enfriar() throws TransicionErroneaException ;

    void pasaTiempo() throws TransicionErroneaException ;

    String getDescripcion();
}

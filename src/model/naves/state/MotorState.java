package model.naves.state;

/**
 * Esta interface define el comportamiento de los diferentes estados del motor
 * de una nave. Cada estado implementará estas acciones de manera específica
 * según su lógica.
 */
public interface MotorState{
    void saltar() throws NaveInoperativaException; ;
    void saltarWarp() throws NaveInoperativaException;
}

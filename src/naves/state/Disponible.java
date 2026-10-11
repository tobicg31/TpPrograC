package naves.state;

import naves.Nave;

/**
 * Esta clase representa uno de los posibles estados del MotorWarp de una nave,
 * en este caso Disponible.
 * 
 * <b>Invariante de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * 
 */
public class Disponible implements MotorState{
    private String descripcion;
    private Nave nave;

    /**
     * Constructor de la clase Disponible.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado Disponible.
     */
    public Disponible(Nave n) {
        assert n != null : "La nave no puede ser nula";
        this.nave = n;
        this.descripcion = "Disponible";
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void prepararSalto() {
        this.nave.setEstado(new PreparandoSalto(this.nave));
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void saltar()  throws TransicionErroneaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: falta preparar el salto. Prepare el salto para comenzar");
    }

    @Override
    public void enfriar()  throws TransicionErroneaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: no se puede enfriar estando ya disponible. Prepare el salto para comenzar");
    }

    @Override
    public void pasaTiempo() throws TransicionErroneaException  {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: ya esta disponible el motor. Prepare el salto para comenzar");
    }

}

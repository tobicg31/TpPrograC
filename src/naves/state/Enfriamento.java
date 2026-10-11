package naves.state;

import naves.Nave;

/**
 * Esta clase representa uno de los posibles estados del MotorWarp de una nave,
 * en este caso Enfriamiento.
 * 
 * <b>Invariante de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * 
 */
public class Enfriamento implements MotorState {
    private Nave nave;
    private String descripcion;

    /**
     * Constructor de la clase Enfriamento.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado Enfriamento.
     */
    public Enfriamento(Nave n) {
        assert n != null : "La nave no puede ser nula";
        this.nave = n;
        this.descripcion = "Enfriamento";
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void prepararSalto()  throws TransicionErroneaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: no se puede preparar el salto enfriando motor. Ponga el motor en disponible");
    }

    @Override
    public void saltar()  throws TransicionErroneaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: no esta preparado el motor. Ponga el motor en disponible");
    }

    @Override
    public void enfriar()  throws TransicionErroneaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new TransicionErroneaException("ERROR: ya esta enfriado el motor. Ponga el motor en disponible");
    }

    @Override
    public void pasaTiempo() {
        this.nave.setEstado(new Disponible(this.nave));
    }
}

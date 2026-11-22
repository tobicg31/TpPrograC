package model.naves.state;

import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.naves.Nave;

/**
 * Esta clase representa uno de los posibles estados del MotorWarp de una nave,
 * en este caso Disponible.
 * 
 * <b>Invariante de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * 
 */
public class Disponible implements MotorState {
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

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void saltar() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        if (this.nave.getCombustible() < 2) {
            throw new NaveInoperativaException("No hay suficiente combustible para saltar. Nave inoperativa");
        } else {
            this.nave.setCombustible(this.nave.getCombustible() - 2);
            this.nave.setEstado(new PreparandoSalto(this.nave));
        }
    }

    @Override
    public void saltarWarp() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        throw new NaveInoperativaException("La nave no está en estado de warp.");
    }
}

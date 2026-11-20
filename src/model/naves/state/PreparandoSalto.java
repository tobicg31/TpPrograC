package model.naves.state;

import model.naves.Nave;

/**
 * Esta clase representa uno de los posibles estados del MotorWarp de una nave,
 * en este caso PreparandoSalto.
 * 
 * <b>Invariante de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * 
 */
public class PreparandoSalto implements MotorState {
    private Nave nave;
    private String descripcion;

    /**
     * Constructor de la clase PreparandoSalto.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado PreparandoSalto.
     */
    public PreparandoSalto(Nave n) {
        assert n != null : "La nave no puede ser nula";
        this.nave = n;
        this.descripcion = "Preparando salto";
    }

    public String getDescripcion() {
        return this.descripcion;
    }


    @Override
    public void saltar() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        if (this.nave.getCombustible() < 2) {
            throw new NaveInoperativaException("ERROR: no hay suficiente combustible para saltar. Nave inoperativa");
        }
        else{
            this.nave.setCombustible(this.nave.getCombustible() - 2);
            if (this.nave.getCombustible()>=5) {
                this.nave.setEstado(new EnWarp(this.nave));
            }
        }
    }

    @Override
    public void saltarWarp() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        if (this.nave.getCombustible() >= 5) {
        throw new NaveInoperativaException("ERROR: Aun no se ha terminado de preparar salto en warp.");
        }
    }
}


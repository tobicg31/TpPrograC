package model.naves.state;

import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.naves.Nave;

/**
 * Esta clase representa uno de los posibles estados del MotorWarp de una nave,
 * en este caso EnWarp.
 * 
 * <b>Invariante de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * 
 */
public class EnWarp implements MotorState {
    private Nave nave;
    private String descripcion;

    /**
     * Constructor de la clase EnWarp.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado EnWarp.
     */
    public EnWarp(Nave n) {
        assert n != null : "La nave no puede ser nula";
        this.nave = n;
        this.descripcion = "En Warp";
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void saltar() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        if (this.nave.getCombustible() < 5) {
            this.nave.setEstado(new PreparandoSalto(this.nave));
        } else {

            if (this.nave.getCombustible() < 2) {
                throw new NaveInoperativaException(
                        "ERROR: no hay suficiente combustible para saltar. Nave inoperativa");
            } else {
                this.nave.setCombustible(this.nave.getCombustible() - 2);
            }
        }
    }

    @Override
    public void saltarWarp() throws NaveInoperativaException {
        assert this.nave != null : "La nave no puede ser nula";
        if (this.nave.getCombustible() < 5) {
            this.nave.setEstado(new PreparandoSalto(this.nave));
            throw new NaveInoperativaException("ERROR: no hay suficiente combustible para saltar en warp.");
        } else {
            this.nave.setCombustible(this.nave.getCombustible() - 5);
            this.nave.setEstado(new Enfriamento(this.nave));
        }
    }
}
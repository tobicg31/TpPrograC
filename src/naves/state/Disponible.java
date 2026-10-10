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

    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public void prepararSalto() {
        this.nave.setEstado(new PreparandoSalto(this.nave));
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void saltar() {
        System.out.println("ERROR: falta preparar el salto. Prepare el salto para comenzar");
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: no se puede enfriar estando ya disponible. Prepare el salto para comenzar");
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void pasaTiempo() {
        System.out.println("ERROR: ya esta disponible el motor. Prepare el salto para comenzar");
        assert this.nave != null : "La nave no puede ser nula";
    }

}

package naves.state;

import naves.Nave;

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
    public void prepararSalto() {
        System.out.println("ERROR: ya se esta preparando el salto. Pase el motor en warp");
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void saltar() {
        this.nave.setEstado(new EnWarp(this.nave));
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: no se puede enfriar mientras se prepara un salto. Pase el motor en warp");
        assert this.nave != null : "La nave no puede ser nula";
    }

    @Override
    public void pasaTiempo() {
        System.out.println("ERROR: preparando un salto no se puede pasar a disponible. Pase el motor en warp");
        assert this.nave != null : "La nave no puede ser nula";
    }

}

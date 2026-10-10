package naves.state;

import naves.Nave;

public class PreparandoSalto implements MotorState {
    private Nave nave;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Constructor de la clase PreparandoSalto.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado PreparandoSalto.
     */
    public PreparandoSalto(Nave n) {
        this.nave = n;
        this.descripcion = "Preparando salto";
    }

    @Override
    public void prepararSalto() {
        System.out.println("ERROR: ya se esta preparando el salto. Pase el motor en warp");
    }

    @Override
    public void saltar() {
        this.nave.setEstado(new EnWarp(this.nave));
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: no se puede enfriar mientras se prepara un salto. Pase el motor en warp");
    }

    @Override
    public void pasaTiempo() {
        System.out.println("ERROR: preparando un salto no se puede pasar a disponible. Pase el motor en warp");
    }

}

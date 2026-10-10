package naves.state;

import naves.Nave;

public class EnWarp implements MotorState {
    private Nave nave;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Constructor de la clase EnWarp.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado EnWarp.
     */
    public EnWarp(Nave n) {
        this.nave = n;
        this.descripcion = "En Warp";
    }

    @Override
    public void prepararSalto() {
        System.out.println(
                "ERROR: no se puede preparar el salto en medio de un salto. Enfrie el motor o pase a disponible");
    }

    @Override
    public void saltar() {
        System.out.println("ERROR: ya se esta en Warp. Enfrie el motor o pase a disponible");
    }

    @Override
    public void enfriar() {
        this.nave.setEstado(new Enfriamento(this.nave));
    }

    @Override
    public void pasaTiempo() {
        this.nave.setEstado(new Disponible(this.nave));
    }
}

package naves.state;

import naves.Nave;

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
    public void prepararSalto() {
        System.out.println("ERROR: no se puede preparar el salto enfriando motor. Ponga el motor en disponible");
    }

    @Override
    public void saltar() {
        System.out.println("ERROR: no esta preparado el motor. Ponga el motor en disponible");
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: ya esta enfriado el motor. Ponga el motor en disponible");
    }

    @Override
    public void pasaTiempo() {
        this.nave.setEstado(new Disponible(this.nave));
    }
}

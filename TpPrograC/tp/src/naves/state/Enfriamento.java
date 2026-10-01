package naves.state;

import naves.Nave;

public class Enfriamento implements MotorState {
    private Nave nave;

    /**
     * Constructor de la clase Enfriamento.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado Enfriamento.
     */
    public Enfriamento(Nave n) {
        this.nave = n;
    }

    @Override
    public void prepararSalto() {
        System.out.println("ERROR: no se puede preparar el salto enfriando motor. Ponga el motor en disponible");
    }

    @Override
    public void enWarp() {
        System.out.println("ERROR: no esta preparado el motor. Ponga el motor en disponible");
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: ya esta enfriado el motor. Ponga el motor en disponible");
    }

    @Override
    public void disponible() {
        this.nave.setEstado(new Disponible(this.nave));
    }
}

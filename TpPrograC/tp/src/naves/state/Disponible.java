package naves.state;

import naves.Nave;

public class Disponible implements MotorState {
    private Nave nave;

    /**
     * Constructor de la clase Disponible.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Nave a la que pertenece el estado Disponible.
     */
    public Disponible(Nave n) {
        this.nave = n;
    }

    @Override
    public void prepararSalto() {
        this.nave.setEstado(new PreparandoSalto(this.nave));
    }

    @Override
    public void saltar() {
        System.out.println("ERROR: falta preparar el salto. Prepare el salto para comenzar");
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: no se puede enfriar estando ya disponible. Prepare el salto para comenzar");
    }

    @Override
    public void pasaTiempo() {
        System.out.println("ERROR: ya esta disponible el motor. Prepare el salto para comenzar");
    }

}

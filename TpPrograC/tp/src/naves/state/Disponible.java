package naves.state;

import naves.Nave;

public class Disponible implements MotorState {
    private Nave nave;

    public Disponible(Nave n) {
        this.nave = n;
    }

    @Override
    public void prepararSalto() {
        this.nave.setEstado(new PreparandoSalto(this.nave));
    }

    @Override
    public void enWarp() {
        System.out.println("ERROR: falta preparar el salto. Prepare el salto para comenzar");
    }

    @Override
    public void enfriar() {
        System.out.println("ERROR: no se puede enfriar estando ya disponible. Prepare el salto para comenzar");
    }

    @Override
    public void disponible() {
        System.out.println("ERROR: ya esta disponible el motor. Prepare el salto para comenzar");
    }

}

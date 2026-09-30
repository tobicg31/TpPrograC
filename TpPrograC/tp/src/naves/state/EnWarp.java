package naves.state;

import naves.Nave;

public class EnWarp implements MotorState {
    private Nave nave;

    public EnWarp(Nave n) {
        this.nave = n;
    }
    @Override
    public void prepararSalto() {
        System.out.println("ERROR: no se puede preparar el salto en medio de un salto. Enfrie el motor o pase a disponible");
    }

    @Override
    public void enWarp() {
        System.out.println("ERROR: ya se esta en Warp. Enfrie el motor o pase a disponible");
    }

    @Override
    public void enfriar() {
        this.nave.setEstado(new Enfriamento(this.nave));
    }

    @Override
    public void disponible() {
        this.nave.setEstado(new Disponible(this.nave));
    }
}

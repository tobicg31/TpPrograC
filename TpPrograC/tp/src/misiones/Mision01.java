package misiones;

import naves.Nave;

public class Mision01 extends Mision {

    public Mision01(String nombre) {
        super(nombre);
    }

    @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 01: Intercepcion-Asistencia | ");
    }

    @Override
    public void cerrar(Nave n) {
        n.setEnergia(n.getEnergia() + 5);
    }

}

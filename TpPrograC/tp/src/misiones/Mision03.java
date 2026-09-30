package misiones;

import naves.Nave;

public class Mision03 extends Mision {
    public Mision03(String nombre) {
        super(nombre);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 03: Retorno seguro | ");
    }

}

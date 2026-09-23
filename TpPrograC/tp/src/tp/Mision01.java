package tp;

public class Mision01 extends Mision{

    @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 01: Intercepcion-Asistencia | ");
    }

    @Override
    public void cerrar(Nave n) {
        n.setEnergia(n.getEnergia()+5);
    }
    
}

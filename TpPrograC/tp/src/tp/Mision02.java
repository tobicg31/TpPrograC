package tp;

public class Mision02 extends Mision{
    @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 02: Recoleccion | ");
    }
    
    @Override
    public void cerrar(Nave n) {
        n.setEnergia(n.getEnergia()+5);
    }
}

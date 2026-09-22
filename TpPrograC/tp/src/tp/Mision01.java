package tp;

public class Mision01 extends Mision{

    @Override
    public void ejecutar(Nave n) {
        n.setCombustible( n.getCombustible() - 4);
        n.setDesgaste(n.getDesgaste() + 4);
        n.setEnergia(n.getEnergia()+5); 
    }

    @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 01: Intercepcion-Asistencia | ");
    }
    
}

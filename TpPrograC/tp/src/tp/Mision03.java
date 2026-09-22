package tp;

public class Mision03 extends Mision{
    @Override
    public void ejecutar(Nave n) {
        n.setCombustible( n.getCombustible() - 4);
        n.setDesgaste(n.getDesgaste() + 4); 
    }
        @Override
    public void evaluar(Nave n) {
        System.out.println("Mision 03: Retorno seguro | ");
    }
}

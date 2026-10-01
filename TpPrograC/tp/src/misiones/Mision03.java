package misiones;

import naves.Nave;

public class Mision03 extends Mision {

    @Override
    public String evaluar(Nave n) {
        String informe = "Mision 03: Retorno seguro | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + n.getCombustible() + " Energia: " + n.getEnergia()
                + " Desgaste: " + n.getDesgaste();
        return informe;
    }

}

package misiones;

import naves.Nave;

public class Mision01 extends Mision {

    @Override
    public String evaluar(Nave n) {
        String informe = "Mision 01: Intercepcion-Asistencia | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + n.getCombustible() + " Energia: " + n.getEnergia()
                + " Desgaste: " + n.getDesgaste();
        return informe;
    }

    @Override
    public void cerrar(Nave n) {
        n.setEnergia(n.getEnergia() + 5);
    }

}

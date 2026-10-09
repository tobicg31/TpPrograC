package misiones;

import naves.Nave;

public class Mision03 extends Mision {

    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#evaluar(naves.Nave)
     * @return Agrega a la bitacora el informe de la misión.
     */
    @Override
    public void evaluar(Nave n) {
        System.out.println("Evaluando misión 01...");
        String informe = "Mision 03: Retorno seguro | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + n.getCombustible() + " Energia: " + n.getEnergia()
                + " Desgaste: " + n.getDesgaste();
        this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
    }

}

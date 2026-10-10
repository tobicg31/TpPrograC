package misiones;

import naves.Nave;

public class Mision01 extends Mision {

    public Mision01(){
        super();
        this.nombre = "Intercepcion-Asistencia";
    }
    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#evaluar(naves.Nave)
     * @return Agrega a la bitacora el informe de la misión.
     */
    @Override
    public void evaluar(Nave n) {
        System.out.println("Evaluando misión 01...");
        String informe = "Mision 01: Intercepcion-Asistencia | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + n.getCombustible() + " Energia: " + n.getEnergia()
                + " Desgaste: " + n.getDesgaste();
        this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
    }

    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#cerrar(naves.Nave)
     * @return Modifica la energia de la nave.
     */
    @Override
    public void cerrar(Nave n) {
        n.setEnergia(n.getEnergia() + 5);
    }

}

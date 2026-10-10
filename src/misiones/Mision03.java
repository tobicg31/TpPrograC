package misiones;

import naves.Nave;

/**
 * Esta clase representa una misión concreta que puede ser ejecutada por una nave.
 */
public class Mision03 extends Mision {

    public Mision03(){
        super();
        this.nombre = "Retorno Seguro";
    }
    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#evaluar(naves.Nave)
     * @return Agrega a la bitacora el informe de la misión.
     */
    @Override
    public void evaluar(Nave n) {
        assert n != null : "La nave no puede ser nula";
        System.out.println("Evaluando misión 03...");
        String informe = "Mision 03: Retorno seguro | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + n.getCombustible() + " Energia: " + n.getEnergia()
                + " Desgaste: " + n.getDesgaste();
        this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
    }

}

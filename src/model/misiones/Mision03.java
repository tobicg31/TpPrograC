package model.misiones;

import model.asistentes.Asistente;
import model.destinoytablero.Destino;
import model.destinoytablero.Tablero;

/**
 * Esta clase representa una misión concreta que puede ser ejecutada por una nave.
 */
public class Mision03 extends Mision {

    public Mision03(Tablero t, Destino d){
        super(t,d,0);
        this.nombre = "Retorno Seguro";
    }
    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#evaluar(naves.Nave)
     * @return Agrega a la bitacora el informe de la misión.
     */
    @Override
    public void evaluar(Asistente asistente) {
        assert asistente.getNave() != null : "La nave no puede ser nula";
        System.out.println("Evaluando misión 03...");
        String informe = "Mision 03: Retorno seguro | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
        informe += "Estado final nave: Combustible: " + asistente.getNave().getCombustible() + " Energia: " + asistente.getNave().getEnergia()
                + " Desgaste: " + asistente.getNave().getDesgaste();
        this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
        if (misionTerminada){
            String informe = "Mision 03: Retorno seguro | combustible gastado: " + this.combustibleNecesario
                + " desgaste efectuado en la nave: " + this.desgaste;
            informe += "Estado final nave: Combustible: " + asistente.getNave().getCombustible() + " Energia: " + asistente.getNave().getEnergia()
                    + " Desgaste: " + asistente.getNave().getDesgaste();
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
        } else {
            String informe = "Mision 03: Retorno seguro | Mision fallida, la quedaste";
            informe += " Motivo del fallo:" + this.error;
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");   
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#cerrar(naves.Nave)
     * @return Se recarga energia y combustible, y se hace mantenimiento.
     */
    @Override
    public void cerrar(Asistente asistente) {
        assert asistente.getNave() != null : "La nave no puede ser nula";
        asistente.NaveModificarEnergiaYCombultible(100,100);
        asistente.hacerMantenimiento();
    }

}

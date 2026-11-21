package model.misiones;

import java.util.Random;

import model.asistentes.Asistente;
import model.destinoytablero.Destino;
import model.destinoytablero.Tablero;

/**
 * Esta clase representa una misión concreta que puede ser ejecutada por una nave.
 */
public class Mision02 extends Mision {

    public Mision02(Tablero t, Destino d){
        super(t,d,10);
        this.nombre = "Recoleccion";
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
        //System.out.println("Evaluando misión 02...")
        if (misionTerminada){
            String informe = "Mision 02: Recoleccion | combustible gastado: " + this.combustibleNecesario
                    + " desgaste efectuado en la nave: " + this.desgaste;
            informe += "Estado final nave: Combustible: " + asistente.getNave().getCombustible() + " Energia: " + asistente.getNave().getEnergia()
                    + " Desgaste: " + asistente.getNave().getDesgaste();
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
        } else {
            String informe = "Mision 02: Recollecion | Mision fallida, la quedaste";
            informe += " Motivo del fallo:" + this.error;
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");   
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#cerrar(naves.Nave)
     * @return La nave recoge entre 20 y 100 gemas.
     */
    @Override
    public void cerrar(Asistente asistente) {
        assert asistente.getNave() != null : "La nave no puede ser nula";
        Random rand = new Random(); 
        int cantGemas = rand.nextInt(20,100);
        String mensaje = "Se recolectaron "+ cantGemas +" gemas exitosamente";
        this.asistente.getBitacora().agregarEntrada(mensaje, tipo: "INFORME");
    }
}

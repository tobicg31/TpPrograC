package model.misiones;

import java.util.Random;

import model.asistentes.Asistente;
import model.destinoytablero.Destino;
import model.destinoytablero.Tablero;

/**
 * Esta clase representa una misión concreta que puede ser ejecutada por una
 * nave.
 */

public class Mision01 extends Mision {
    Random rand = new Random();
    private int combustibleTrans = rand.nextInt(50);
    private int energiaTrans = rand.nextInt(50);

    public Mision01(Tablero t, Destino d) {
        super(t, d, 5);
        this.nombre = "Intercepcion-Asistencia";

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
        if (misionTerminada) {
            String informe = "Mision 01: Intercepcion-Asistencia | combustible gastado: " + this.combustibleNecesario
                    + " desgaste efectuado en la nave: " + this.desgaste;
            informe += " Estado final nave: Combustible: " + asistente.getNave().getCombustible() + " Energia: "
                    + asistente.getNave().getEnergia()
                    + " Desgaste: " + asistente.getNave().getDesgaste();
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
        } else {
            String informe = "Mision 01: Intercepcion-Asistencia | Mision fallida, la quedaste";
            informe += " Motivo del fallo: " + this.error;
            this.asistente.getBitacora().agregarEntrada(informe, "INFORME");
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see misiones.Mision#cerrar(naves.Nave)
     * @return Modifica la energia y combustible de la nave.
     */
    @Override
    public void cerrar(Asistente asistente) {
        assert asistente.getNave() != null : "La nave no puede ser nula";
        asistente.NaveModificarCombultible(combustibleNecesario);
        asistente.NaveModificarEnergia(energiaNecesaria);
    }

}

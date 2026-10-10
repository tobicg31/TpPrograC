package misiones;

import naves.Nave;

public class Mision02 extends Mision {

    public Mision02(){
        super();
        this.nombre = "Recoleccion";
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
        System.out.println("Evaluando misión 02...");
        String informe = "Mision 02: Recoleccion | combustible gastado: " + this.combustibleNecesario
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
        assert n != null : "La nave no puede ser nula";
        n.setEnergia(n.getEnergia() + 5);
    }
}

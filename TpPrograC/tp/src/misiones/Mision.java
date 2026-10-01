package misiones;

import asistentes.Asistente;
import misiones.excepciones.NaveMantenimientoException;
import misiones.excepciones.NaveSinRecursosException;
import naves.Nave;

public abstract class Mision {
    protected String nombre;
    protected int combustibleNecesario, desgaste;
    protected Asistente asistente; // asistete ???

    public Mision() {
        this.combustibleNecesario = 4;
        this.desgaste = 4;
        this.asistente = null;
    }

    public String getNombreMision() {
        return nombre;
    }

    public void preparar(Nave n) throws NaveSinRecursosException, NaveMantenimientoException {
        System.out.println("preparo la nave...");
        if (!((n.getCombustible() - this.combustibleNecesario >= 0) && (n.getDesgaste() + this.desgaste <= 100))) {
            throw new NaveSinRecursosException("Fallo de recursos");
        } else if ((n.requiereMantenimineto())) {
            throw new NaveMantenimientoException("La nave requiere mantenimiento");
        } else {
            System.out.println("Nave preparada!");
        }
    }

    public void ejecutar(Nave n) {
        n.setCombustible(n.getCombustible() - this.combustibleNecesario);
        n.setDesgaste(n.getDesgaste() + this.desgaste);
    }

    public abstract String evaluar(Nave n); // fecha, recursos, que hizo

    public void cerrar(Nave n) {
        this.asistente.getBitacora().agregarEntrada(this.evaluar(n), "INFORME");
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave proporcionada.
     * 
     * @param n Este parámetro representa la nave que se utilizará para ejecutar la
     *          misión, no puede ser nulo.
     * @throws NaveSinRecursosException   Esta excepción se lanza si la nave no
     *                                    tiene suficientes recursos para ejecutar
     *                                    la misión.
     * @throws NaveMantenimientoException Esta excepción se lanza si la nave
     *                                    requiere mantenimiento.
     * @return Realiza el paso a paso de la ejecución de la misión, incluyendo
     *         preparación, ejecución, evaluación y cierre, utilizando la nave
     *         proporcionada.
     */
    public void ejecutarMision(Nave n) throws NaveSinRecursosException, NaveMantenimientoException {
        preparar(n);
        ejecutar(n);
        evaluar(n);
        cerrar(n);
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

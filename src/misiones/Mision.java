package misiones;

import asistentes.Asistente;
import misiones.excepciones.NaveMantenimientoException;
import misiones.excepciones.NaveSinRecursosException;
import naves.Nave;

public abstract class Mision {
    protected String nombre;
    protected int combustibleNecesario, desgaste;
    protected Asistente asistente;

    public Mision() {
        this.combustibleNecesario = 4;
        this.desgaste = 4;
        this.asistente = null;
    }

    public String getNombreMision() {
        return nombre;
    }

    /**
     * Este método permite preparar la nave para ejecutar la misión.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para preparar la
     *          misión.
     * @throws NaveSinRecursosException   En caso de no cumplir con los recursos
     *                                    necesarios para ejecutar la misión.
     * @throws NaveMantenimientoException En caso de que la nave requiera
     *                                    mantenimiento.
     */
    public void preparar(Nave n) throws NaveSinRecursosException, NaveMantenimientoException {
        assert n != null : "La nave no puede ser nula";
        System.out.println("preparo la nave...");
        if (!((n.getCombustible() - this.combustibleNecesario >= 0) && (n.getDesgaste() + this.desgaste <= 100))) {
            throw new NaveSinRecursosException("Fallo de recursos");
        } else if ((n.requiereMantenimineto())) {
            throw new NaveMantenimientoException("La nave requiere mantenimiento");
        } else {
            System.out.println("Nave preparada!");
        }
    }

    /**
     * Este método permite ejecutar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para ejecutar la
     *          misión.
     * @return Realiza la ejecución de la misión, actualizando los recursos de la
     *         nave según los requerimientos de la misión.
     */
    public void ejecutar(Nave n) {
        assert n != null : "La nave no puede ser nula";
        n.setCombustible(n.getCombustible() - this.combustibleNecesario);
        n.setDesgaste(n.getDesgaste() + this.desgaste);
    }

    /**
     * Este método permite evaluar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para evaluar la
     *          misión.
     */
    public abstract void evaluar(Nave n); // fecha, recursos, que hizo

    /**
     * Este método permite cerrar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para cerrar la
     *          misión.
     */
    public void cerrar(Nave n) {
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
        assert n != null : "La nave no puede ser nula";
        preparar(n);
        ejecutar(n);
        evaluar(n);
        cerrar(n);
    }

    /**
     * Este método permite asociar un asistente a la misión.
     * <b>PRE:</b>
     * - asistente != null
     * 
     * @param asistente Este parámetro representa el asistente que se desea asociar
     *                  a la misión, no puede ser nulo.
     * @return Asocia el asistente proporcionado a la misión.
     */
    public void setAsistente(Asistente asistente) {
        assert asistente != null : "El asistente no puede ser nulo";
        this.asistente = asistente;
    }

    /**
     * Este método permite establecer el nombre de la misión.
     * <b>PRE:</b>
     * - nombre != null
     * 
     * @param nombre Este parámetro representa el nombre que se desea asignar a la
     *               misión, no puede ser nulo.
     * @return Establece el nombre de la misión con el valor proporcionado.
     */
    public void setNombre(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
    }

}

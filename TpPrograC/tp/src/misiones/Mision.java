package misiones;

import misiones.excepciones.NaveSinRecursosException;
import naves.Nave;

public abstract class Mision {
    protected String nombre;
    protected int combustibleNecesario, desgaste;

    public Mision(String nombre) {
        this.nombre = nombre;
        this.combustibleNecesario = 4;
        this.desgaste = 4;
    }

    public String getNombreMision() {
        return nombre;
    }

    public void preparar(Nave n) throws NaveSinRecursosException {
        System.out.println("preparo la nave...");
        if (!((n.getCombustible() - combustibleNecesario > 0) && (n.getDesgaste() + desgaste < 100))) {
            throw new NaveSinRecursosException("Fallo de recursos");
        } else
            System.out.println("Nave preparada!");
    }

    public void ejecutar(Nave n) {
        n.setCombustible(n.getCombustible() - combustibleNecesario);
        n.setDesgaste(n.getDesgaste() + desgaste);
    }

    public abstract void evaluar(Nave n); // fecha, recursos, que hizo

    public void cerrar(Nave n) {
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave proporcionada.
     * 
     * @param n Este parámetro representa la nave que se utilizará para ejecutar la misión, no puede ser nulo.
     * @throws NaveSinRecursosException Esta excepción se lanza si la nave no tiene suficientes recursos para ejecutar la misión.
     */
    public void ejecutarMision(Nave n) throws NaveSinRecursosException {
        // Método del Patrón Template
        preparar(n);
        ejecutar(n);
        evaluar(n);
        cerrar(n);
    }

}

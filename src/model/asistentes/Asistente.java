package model.asistentes;

import model.bitacoras.Bitacora;
import model.destinoytablero.Tablero;
import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.misiones.Mision;
import model.misiones.excepciones.NaveSinRecursosException;
import model.misiones.excepciones.NaveMantenimientoException;
import model.naves.Nave;
import model.tripulantes.decorator.Liquidable;

/**
 * Esta clase representa al Asistente de Comandos que se encarga de ejecutar
 * misiones utilizando una nave asociada.Contiene una bitácora para registrar
 * los resultados de las misiones ejecutadas.
 * 
 * <b>Invariantes de clase:</b>
 * - nave != null luego de completarse la inicialización.
 * - bitacora != null luego de completarse la inicialización.
 * 
 */
public class Asistente {
    private Nave nave;
    private Bitacora bitacora;
    protected Tablero tablero;

    private boolean invariante() {
        return this.nave != null && this.bitacora != null;
    }

    /**
     * Constructor de la clase Asistente.
     * <b>PRE:</b>
     * - nave != null
     * 
     * @param nave Este parámetro representa la nave que se desea asociar al
     *             asistente.
     * @return Crea un nuevo objeto Asistente con la nave proporcionada y una nueva
     *         bitácora.
     */
    public Asistente(Nave nave, Tablero tablero) {
        this.nave = nave;
        this.bitacora = new Bitacora();
        this.tablero = tablero;
        assert invariante() : "Ni la nave ni la bitacora deben ser nulos";
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    /**
     * Este método permite al asistente interactuar con la nave asociada.
     * <b>PRE:</b>
     * - nave != null
     * <b>POST:</b>
     * - Se registra en la bitácora el resultado de la interacción con la nave.
     */
    public void hacerMantenimiento() {
        this.nave.setDesgaste(0);
        this.bitacora.agregarEntrada("Se ha realizado mantenimiento a la nave", "NAVE");
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave asociada al
     * asistente.
     * <b>PRE:</b>
     * - mision != null
     * 
     * @param mision Este parámetro representa la misión que se desea ejecutar.
     * @return Registra en la bitácora el resultado de la ejecución de la misión.
     */
    public void ejecutarMision(Mision mision) {

        assert invariante() : "Ni la nave ni la bitacora deben ser nulos";
        assert mision != null : "La misión no puede ser nula";
        try {
            mision.setAsistente(this);
            mision.ejecutarMision(this);
            this.bitacora.agregarEntrada("Mision " + mision.getNombreMision() + " ejecutada con exito", "INFO");
        } catch (NaveSinRecursosException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(),
                    "ERROR");
        } catch (NaveMantenimientoException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(),
                    "ERROR");
        }
    }

    public void agregarTripulante(Liquidable t) {
        this.nave.agregarTripulante(t);
    }

    public void consultarBitacora() {
        this.bitacora.consultarBitacora();
    }

    public void saltar() {
        try {
            String mensaje = "Cambio de estado: " + getEstadoMotor();
            nave.saltar();
            this.bitacora.agregarEntrada(mensaje + " a: " + getEstadoMotor(), "CAMBIO ESTADO");
        } catch (NaveInoperativaException e) {
            this.bitacora.agregarEntrada(e.getMessage(), "ERROR");
        }
    }

    public void saltarWarp() throws NaveInoperativaException {
        String mensaje = "Cambio de estado: " + getEstadoMotor();
        nave.saltarWarp();
        this.bitacora.agregarEntrada(mensaje + " a: " + getEstadoMotor(), "CAMBIO ESTADO");
    }

    public String getEstadoMotor() {
        return nave.getMotor().getDescripcion();
    }

    public void NaveSacarEnergia(int energia) throws NaveInoperativaException {
        nave.sacaEnergia(energia);
    }

    public void NaveModificarEnergia(int energia) {
        nave.modificarEnergia(energia);
    }
    public void NaveModificarCombultible(int combustible) {
        nave.modificarCombustible(combustible);
    }

    public Nave getNave() {
        return this.nave;
    }

    public boolean hayCombustible() {
        return this.nave.getCombustible() > 1;
    }
}

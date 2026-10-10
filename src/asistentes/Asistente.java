package asistentes;

import bitacoras.Bitacora;
import misiones.Mision;
import misiones.excepciones.NaveSinRecursosException;
import misiones.excepciones.NaveMantenimientoException;
import naves.Nave;
import tripulantes.Tripulante;
import tripulantes.decorator.Liquidable;

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
     * @return Crea un nuevo objeto Asistente con la nave proporcionada y una nueva bitácora.
     */
    public Asistente(Nave nave) {
        this.nave = nave;
        this.bitacora = new Bitacora();
        assert invariante() : "Ni la nave ni la bitacora deben ser nulos";
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void hacerMantenimiento() {
        this.nave.setDesgaste(0);
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
            mision.ejecutarMision(this.nave);
            this.bitacora.agregarEntrada("Mision " + mision.getNombreMision() + " ejecutada con exito", "INFO");
        } catch (NaveSinRecursosException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(),
                    "ERROR");
        } catch (NaveMantenimientoException e) {
            this.bitacora.agregarEntrada("Error al ejecutar mision " + mision.getNombreMision() + ": " + e.getMessage(),
                    "ERROR");
        }
    }

    public void agregarTripulante(Liquidable t){
        this.nave.agregarTripulante(t);
    }

    public void consultarBitacora() {
        this.bitacora.consultarBitacora();
    }

    public void prepararSalto(){
        nave.getMotor().prepararSalto();
    }
    public void saltar(){
        nave.getMotor().saltar();
    }
    public void enfriar(){
        nave.getMotor().enfriar();
    }
    public void pasaTiempo(){
        nave.getMotor().pasaTiempo();
    }
    public String getEstadoMotor(){
        return nave.getMotor().getDescripcion();
    }

}

package model.naves;

import java.util.ArrayList;

import model.asistentes.Asistente;
import model.elementosUniverso.ElementoDelUniverso;
import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.naves.state.Disponible;
import model.naves.state.MotorState;
import model.tripulantes.decorator.Liquidable;

/**
 * Esta clase representa las naves.
 * 
 * <b>Invariantes de clase:</b>
 * - combustible >= 0
 * - energia >= 0
 * - desgaste >= 0
 * 
 */
public abstract class Nave implements ElementoDelUniverso {
    protected int combustible, maxComb, energia, maxEnergia, desgaste, maxDesgaste;
    protected boolean mantenimiento;
    protected ArrayList<Liquidable> tripulantes;
    protected MotorState motorWarp;

    private boolean invariante() {
        return this.combustible >= 0 && this.energia >= 0 && this.desgaste >= 0;
    }

    /**
     * Constructor de la clase Nave.
     * <b>PRE:</b>
     * - combustible >= 0
     * - energia >= 0
     * - desgaste >= 0
     * 
     * @param combustible Este parámetro representa la cantidad de combustible de la
     *                    nave.
     * @param energia     Este parámetro representa la cantidad de energía de la
     *                    nave.
     * @param desgaste    Este parámetro representa el nivel de desgaste de la nave.
     */
    public Nave(int combustible, int energia, int desgaste) {
        assert combustible >= 0 : "El combustible no puede ser negativo";
        assert energia >= 0 : "La energía no puede ser negativa";
        assert desgaste >= 0 : "El desgaste no puede ser negativo";
        this.maxComb = 100;
        this.maxEnergia = 100;
        this.maxDesgaste = 100;
        this.tripulantes = new ArrayList<Liquidable>();
        this.motorWarp = new Disponible(this);
        this.mantenimiento = false;
        this.combustible = combustible;
        this.energia = energia;
        this.desgaste = desgaste;
    }

    public void interactuar(Asistente asistente) throws NaveInoperativaException {
        // La nave no realiza ninguna interacción propia con el tablero.
    }

    public void agregarTripulante(Liquidable t) {
        this.tripulantes.add(t);
    }

    public MotorState getMotor() {
        return this.motorWarp;
    }

    public int getCombustible() {
        return combustible;
    }

    /**
     * Establece la cantidad de combustible de la nave.
     * <b>PRE:</b>
     * - combustible >= 0
     * 
     * @param combustible Este parámetro representa la cantidad de combustible de la
     *                    nave.
     */
    public void setCombustible(int combustible) {
        assert combustible >= 0 : "El combustible no puede ser negativo";
        this.combustible = combustible;
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

    public int getEnergia() {
        return energia;
    }

    /**
     * Establece la cantidad de energía de la nave.
     * <b>PRE:</b>
     * - energia >= 0
     * 
     * @param energia Este parámetro representa la cantidad de energía de la nave.
     */
    public void setEnergia(int energia) {
        assert energia >= 0 : "La energía no puede ser negativa";
        this.energia = energia;
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

    public int getDesgaste() {
        return desgaste;
    }

    public int getMaxComb() {
        return maxComb;
    }

    public int getMaxEnergia() {
        return maxEnergia;
    }

    public int getMaxDesgaste() {
        return maxDesgaste;
    }

    public boolean requiereMantenimiento() {
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
        return mantenimiento;
    }

    /**
     * Establece el nivel de desgaste de la nave.
     * <b>PRE:</b>
     * - desgaste >= 0
     * 
     * @param desgaste Este parámetro representa el nivel de desgaste de la nave.
     */
    public void setDesgaste(int desgaste) {
        assert desgaste >= 0 : "El desgaste no puede ser negativo";
        this.desgaste = desgaste;
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

    /**
     * Establece el estado del motor de la nave.
     * <b>PRE:</b>
     * - estado != null
     * 
     * @param estado Representa el nuevo estado de la nave.
     */
    public void saltar() throws NaveInoperativaException {
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
        this.motorWarp.saltar();

    }

    public void saltarWarp() throws NaveInoperativaException {
        assert invariante()
                : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
        this.motorWarp.saltarWarp();
    }

    /**
     * Metodo llamado desde Obstaculo, el cual disminuye la energia de la nave.
     * <b>PRE:</b>
     * - energia > 0
     * 
     * @throws NaveInoperativa si la energia final se vuelve menor o igual cero.
     *                         <b>POST:</b>
     *                         -energia final menor a energia inicial
     */
    public void sacaEnergia(int energia) throws NaveInoperativaException {

        if (this.energia - energia > 0) {
            this.energia -= energia;
        } else {
            throw new NaveInoperativaException("La nave ha quedado sin energia, la mision falló");
        }

    }

    /**
     * Metodo llamado desde Ayuda, el cual aumenta la energia y el combustible de la
     * nave.
     * <b>PRE:</b>
     * - energia > 0
     * - combustible > 0
     * <b>POST:</b>
     * -energia final mayor a energia inicial.
     * -combustible inicial mayor a combustible inicial.
     */
    public void modificarEnergia(int energia) {
        if (getEnergia() + energia = getMaxEnergia()){
            setEnergia(getMaxEnergia());
        } else {
            setEnergia(getEnergia() + energia);
        }
    }

    public void modificarCombustible(int combustible){
        if (getCombustible() + combustible = getMaxComb()){
            setCombustible(getMaxComb());
        } else {
            setCombustible(getCombustible() + combustible);
        }
    }

    /**
     * Metodo que modifica el estado del motor de la nave.
     * <b>PRE:</b>
     * - estado != null
     * <b>POST:</b>
     * -motorWarp de la nave es igual al estado pasado por parametro.
     */
    public void setEstado(MotorState estado) {
        assert estado != null : "El estado no puede ser nulo";
        this.motorWarp = estado;
    }
}
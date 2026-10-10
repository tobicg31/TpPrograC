package naves;

import java.util.ArrayList;

import naves.state.Disponible;
import naves.state.MotorState;
import tripulantes.Tripulante;

/**
 * Esta clase representa las naves.
 *  
 * <b>Invariantes de clase:</b>
 * - combustible >= 0
 * - energia >= 0
 * - desgaste >= 0
 * 
 */
public abstract class Nave {
    protected int combustible, maxComb, energia, maxEnergia, desgaste, maxDesgaste;
    protected boolean mantenimineto;
    protected ArrayList<Tripulante> tripulantes;
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
        this.tripulantes = new ArrayList<Tripulante>();
        this.motorWarp = new Disponible(this);
        this.mantenimineto = false;
        this.combustible = combustible;
        this.energia = energia;
        this.desgaste = desgaste;
    }

    public void agregarTripulante(Tripulante t){
        this.tripulantes.add(t);
    }

    public MotorState getMotor(){
        return this.motorWarp;
    }

    public int getCombustible() {
        return combustible;
    }

    /**
     * Establece la cantidad de combustible de la nave.
     * <b>PRE:</b>
     * - combustible >= 0
     * @param combustible Este parámetro representa la cantidad de combustible de la nave.
     */
    public void setCombustible(int combustible) {
        assert combustible >= 0 : "El combustible no puede ser negativo";
        this.combustible = combustible;
        assert invariante() : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

    public int getEnergia() {
        return energia;
    }

    /**
     * Establece la cantidad de energía de la nave.
     * <b>PRE:</b>
     * - energia >= 0
     * @param energia Este parámetro representa la cantidad de energía de la nave.
     */
    public void setEnergia(int energia) {
        assert energia >= 0 : "La energía no puede ser negativa";
        this.energia = energia;
         assert invariante() : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
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

    public boolean requiereMantenimineto() {
        assert invariante() : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
        return mantenimineto;
    }

    /**
     * Establece el nivel de desgaste de la nave.
     * <b>PRE:</b>
     * - desgaste >= 0
     * @param desgaste Este parámetro representa el nivel de desgaste de la nave.
     */
    public void setDesgaste(int desgaste) {
        assert desgaste >= 0 : "El desgaste no puede ser negativo";
        this.desgaste = desgaste;
        assert invariante() : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

    /**
     * Establece el estado del motor de la nave.
     * <b>PRE:</b>
     * - estado != null
     * @param estado Representa el nuevo estado de la nave.
     */
    public void setEstado(MotorState estado) {
        assert estado != null : "El estado no puede ser nulo";
        this.motorWarp = estado;
        assert invariante() : "Invariante de clase violada: combustible, energia y desgaste deben ser mayores o iguales a 0";
    }

}

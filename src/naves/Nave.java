package naves;

import java.util.ArrayList;

import naves.state.Disponible;
import naves.state.MotorState;
import tripulantes.Tripulante;

public abstract class Nave {
    protected int combustible, maxComb, energia, maxEnergia, desgaste, maxDesgaste;
    protected boolean mantenimineto;
    protected ArrayList<Tripulante> tripulantes;
    protected MotorState motorWarp;

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
    public MotorState getMotor(){
        return this.motorWarp;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
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
        return mantenimineto;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    public void setEstado(MotorState estado) {
        this.motorWarp = estado;
    }

}

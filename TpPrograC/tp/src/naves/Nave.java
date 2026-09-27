package naves;

import java.util.ArrayList;

import asistentes.Asistente;
import misiones.Mision;
import naves.state.MotorState;
import tripulantes.Tripulante;

public abstract class Nave {
    private int combustible, maxComb, energia, maxEnergia, desgaste, maxDesgaste;
    private boolean mantenimineto;
    ArrayList<Tripulante> tripulantes;
    MotorState motorWarp;
    Asistente asistente;

    public Nave(int comb, int ener, int des) {
        this.maxComb = 100; // hace falta tener atributos de maximo o con aclararlo en el contrato alcanza
        this.maxEnergia = 100;
        this.maxDesgaste = 100;
        this.tripulantes = new ArrayList<Tripulante>();
        // motor disponible Disponible(this)
        this.mantenimineto = false;
        this.combustible = comb;
        this.energia = ener;
        this.desgaste = des;
        this.asistente = new Asistente(this);
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

    public boolean isMantenimineto() {
        return mantenimineto;
    }

    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    public void ejecutarMision(Mision mision) {
        this.asistente.ejecutarMision(mision);
    }

}

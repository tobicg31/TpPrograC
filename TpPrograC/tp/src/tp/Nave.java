package tp;

import java.util.ArrayList;

public abstract class Nave {
    private int combustible, maxComb, energia, maxEnergia, desgaste, maxDesgaste;
    ArrayList<Tripulante> tripulantes;
    MotorState motorWarp;
    Asistente asistente;
    Bitacora bitacora;
    
    public Nave(int comb, int ener, int des) {
        this.maxComb = 100; //hace falta tener atributos de maximo o con aclararlo en el contrato alcanza
        this.maxEnergia = 100;
        this.maxDesgaste = 100;
        this.tripulantes = new ArrayList<Tripulante>();
        //motor disponible Disponible(this)
        this.bitacora=new Bitacora();
        this.combustible = comb;
        this.energia = ener;
        this.desgaste = des;
    }
    
}

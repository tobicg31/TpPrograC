package model.elementosUniverso;

import model.asistentes.Asistente;
public class Ayuda implements ElementoDelUniverso{
    private int combustible, energia;

    public Ayuda(int com, int energia){
        this.combustible = com;
        this.energia = energia;
    }

    @Override
    public void interactuar(Asistente asistente) {
        asistente.NaveModificarEnergia(this.energia);
        asistente.NaveModificarCombultible(this.combustible);
    }
    
}

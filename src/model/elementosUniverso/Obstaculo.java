package model.elementosUniverso;

import model.naves.Nave;
public class Obstaculo implements ElementoDelUniverso{
    private int energia;

    @Override
    public Obstaculo(int energia){
        this.energia = energia;
    }
    public void interactua(Nave nave) {
        nave.sacaEnergia(energia);
    }
    
}

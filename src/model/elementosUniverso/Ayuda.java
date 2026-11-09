package model.elementosUniverso;

import model.naves.Nave;
public class Ayuda implements ElementoDelUniverso{
    private int combustible, energia;

    public Ayuda(int com, int energia){
        this.combustible = com;
        this.energia = energia;
    }

    @Override
    public void interactua(Nave nave) {
        nave.aumentarEnergiayCombustible(energia, combustible);
    }
    
}

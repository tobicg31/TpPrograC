package model.elementosUniverso;

import model.elementosUniverso.excepciones.NaveInoperativa;
import model.naves.Nave;
public class Obstaculo implements ElementoDelUniverso{
    private int energia;

    @Override
    public Obstaculo(int energia){
        this.energia = energia;
    }
    public void interactua(Nave nave) throws NaveInoperativa {
        try {
            nave.sacaEnergia(energia);
        } catch (NaveInoperativa e) {
            throw e;
        }
    }
    
}

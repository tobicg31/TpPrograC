package model.elementosUniverso;

import model.asistentes.Asistente;
import model.elementosUniverso.excepciones.NaveInoperativa;
import model.naves.Nave;
public class Obstaculo implements ElementoDelUniverso{
    private int energia;

    @Override
    public Obstaculo(int energia){
        this.energia = energia;
    }
    public void interactuar(Asistente asistente) throws NaveInoperativa {
        try {
            asistente.NaveSacarEnergia(energia);
        } catch (NaveInoperativa e) {
            throw e;
        }
    }
    
}

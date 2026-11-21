package model.elementosUniverso;

import model.asistentes.Asistente;
import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.naves.Nave;
public class Obstaculo implements ElementoDelUniverso{
    private int energia;

    @Override
    public Obstaculo(int energia){
        this.energia = energia;
    }
    public void interactuar(Asistente asistente) throws NaveInoperativaException{ {
        try {
            asistente.NaveSacarEnergia(energia);
        } catch (NaveInoperativaException e) {
            throw e;
        }
    }
    
    }
}

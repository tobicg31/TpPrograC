package model.elementosUniverso;

import model.asistentes.Asistente;
import model.elementosUniverso.excepciones.NaveInoperativaException;

public class Obstaculo implements ElementoDelUniverso {
    private int energia;

    public Obstaculo(int energia) {
        this.energia = energia;
    }

    public void interactuar(Asistente asistente) throws NaveInoperativaException {
        try {
            asistente.NaveSacarEnergia(energia);
        } catch (NaveInoperativaException e) {
            throw e;
        }

    }
}

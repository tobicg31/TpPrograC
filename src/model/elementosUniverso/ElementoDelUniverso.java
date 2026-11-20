package model.elementosUniverso;

import model.asistentes.Asistente;
import model.elementosUniverso.excepciones.NaveInoperativa;
import model.naves.Nave;

public interface ElementoDelUniverso {
    public void interactuar(Asistente asistente) throws NaveInoperativa ;
} 
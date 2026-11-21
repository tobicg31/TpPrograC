package model.elementosUniverso;

import model.asistentes.Asistente;
import model.elementosUniverso.excepciones.NaveInoperativaException;

public interface ElementoDelUniverso {
    public void interactuar(Asistente asistente) throws NaveInoperativaException ;
} 
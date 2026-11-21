package model.elementosUniverso;

import model.elementosUniverso.excepciones.NaveInoperativaException;

public interface InteraccionNave {
    boolean choca(InteraccionNave nave);
    boolean chocaExploradora() throws NaveInoperativaException;
    boolean chocaCarguera() throws NaveInoperativaException;
    boolean chocaCombate();
}

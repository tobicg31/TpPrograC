package model.naves;

import model.elementosUniverso.InteraccionNave;
import model.elementosUniverso.excepciones.NaveInoperativaException;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, una
 * Exploradora.
 */
public class Exploradora extends Nave implements InteraccionNave {
    public Exploradora() {
        super(80, 100, 0);
    }

    public boolean choca(InteraccionNave nave) throws NaveInoperativaException {
        return nave.chocaExploradora();
    }

    public boolean chocaExploradora() {
        return true;
    }

    public boolean chocaCarguera() {
        return true;
    }

    public boolean chocaCombate() throws NaveInoperativaException {
        throw new NaveInoperativaException("Perdio la nave y exploto");
    }
}

package model.naves;

import model.elementosUniverso.InteraccionNave;
import model.elementosUniverso.excepciones.NaveInoperativaException;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, una de Combate.
 */
public class Combate extends Nave implements InteraccionNave {
    public Combate() {
        super(100, 60, 0);
    }

    public boolean choca(InteraccionNave nave) {
        return nave.chocaCombate();
    }

    public boolean chocaExploradora() {
        return true;
    }

    public boolean chocaCarguera() throws NaveInoperativaException {
        throw new NaveInoperativaException("Perdio la nave y exploto");
    }

    public boolean chocaCombate() {
        return true;
    }
}
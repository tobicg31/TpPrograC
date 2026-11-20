package model.naves;

import model.elementosUniverso.interaccionNave;
import model.elementosUniverso.excepciones.NaveInoperativa;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, una Exploradora.
 */
public class Exploradora extends Nave implements interaccionNave {
    public Exploradora() {
        super(80, 100, 0);
    }

    boolean choca(interaccionNave nave){
        return nave.chochaExploradora();
    }
    boolean chocaExploradora(){
        return true;
    }
    boolean chocaCarguera(){
        return true;
    }
    boolean chocaCombate() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
}

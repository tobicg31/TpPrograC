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

    boolean chocha(interaccionNave nave){
        return nave.chochaExploradora();
    }
    boolean chochaExploradora(){
        return true;
    }
    boolean chochaCarguera(){
        return true;
    }
    boolean chochaCombate() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
}

package model.naves;

import model.elementosUniverso.interaccionNave;
import model.elementosUniverso.excepciones.NaveInoperativa;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, un Carguero.
 */
public class Carguero extends Nave implements interaccionNave {
    public Carguero() {
        super(60, 80, 0);
    }
    boolean chocha(interaccionNave nave){
        return nave.chochaCarguera()
    }
    boolean chochaExploradora() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
    boolean chochaCarguera(){
        return true;
    }
    boolean chochaCombate(){
        return true;
    }
}

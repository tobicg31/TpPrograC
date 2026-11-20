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
    boolean choca(interaccionNave nave){
        return nave.chochaCarguera()
    }
    boolean chocaExploradora() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
    boolean chocaCarguera(){
        return true;
    }
    boolean chocaCombate(){
        return true;
    }
}

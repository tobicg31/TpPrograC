package model.naves;

import model.elementosUniverso.InteraccionNave;
import model.elementosUniverso.excepciones.NaveInoperativa;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, una Exploradora.
 */
public class Exploradora extends Nave implements InteraccionNave {
    public Exploradora() {
        super(80, 100, 0);
    }

    public boolean choca(InteraccionNave nave){
        return nave.chocaExploradora();
    }
    public boolean chocaExploradora(){
        return true;
    }
    public boolean chocaCarguera(){
        return true;
    }
    public boolean chocaCombate() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
}

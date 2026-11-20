package model.naves;

import model.elementosUniverso.interaccionNave;
import model.elementosUniverso.excepciones.NaveInoperativa;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, una de Combate.
 */
public class Combate extends Nave implements interaccionNave {
    public Combate() {
        super(100, 60, 0);
    }
   boolean choca(interaccionNave nave){
        return nave.chochaCombate();
    }
    boolean chocaExploradora(){
        return true;
    }
    boolean chocaCarguera() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
    boolean chocaCombate(){
        return true;
    }
} 
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
   boolean chocha(interaccionNave nave){
        return nave.chochaCombate();
    }
    boolean chochaExploradora(){
        return true;
    }
    boolean chochaCarguera() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
    boolean chochaCombate(){
        return true;
    }
} 
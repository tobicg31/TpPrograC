package model.naves;

import model.elementosUniverso.interaccionNave;

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
        return "Pacto de Paz";
    }
    boolean chochaCarguera(){
        return "Gana";
    }
    boolean chochaCombate(){
        return "Pierde";
    }
}

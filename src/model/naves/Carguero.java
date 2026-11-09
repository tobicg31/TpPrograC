package model.naves;

import model.elementosUniverso.interaccionNave;

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
    boolean chochaExploradora(){
        return "Pierde";
    }
    boolean chochaCarguera(){
        return "Pacto de Paz";
    }
    boolean chochaCombate(){
        return "Gana";
    }
}

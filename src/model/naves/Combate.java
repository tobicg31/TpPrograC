package model.naves;

import model.elementosUniverso.interaccionNave;

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
        return "Gana";
    }
    boolean chochaCarguera(){
        return "Pierde";
    }
    boolean chochaCombate(){
        return "Pacto de Paz";
    }
} 
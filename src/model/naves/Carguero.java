package model.naves;

import model.asistentes.Asistente;
import model.elementosUniverso.InteraccionNave;
import model.elementosUniverso.excepciones.NaveInoperativa;

/**
 * Esta clase representa un tipo de nave Concreta, en este caso, un Carguero.
 */
public class Carguero extends Nave implements InteraccionNave {
    public Carguero() {
        super(60, 80, 0);
    }
    public boolean choca(InteraccionNave nave){
        return nave.chocaCarguera();
    }
    public boolean chocaExploradora() throws NaveInoperativa{
        throw new NaveInoperativa("Perdio la nave y exploto");
    }
    public boolean chocaCarguera(){
        return true;
    }
    public boolean chocaCombate(){
        return true;
    }
}

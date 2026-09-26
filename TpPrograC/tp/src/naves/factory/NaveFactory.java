package naves.factory;

import naves.Carguero;
import naves.Combate;
import naves.Exploradora;
import naves.Nave;

public class NaveFactory {
    public Nave getNave(String tipoNave) {
        switch (tipoNave) {
            case "Carguero":
                return new Carguero();
            case "Combate":
                return new Combate();
            default:
                return new Exploradora();
        }
    }
}
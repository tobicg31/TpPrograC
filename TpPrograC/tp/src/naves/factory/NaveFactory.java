package naves.factory;

import naves.Carguero;
import naves.Combate;
import naves.Exploradora;
import naves.Nave;

public class NaveFactory {
    public static Nave getNave(String tipoNave) {
        switch (tipoNave) {
            case "Carguero":
                return new Carguero();
            case "Combate":
                return new Combate();
            case "Exploradora":
                return new Exploradora();
            default:
                return null;
        }
    }
}
package naves.factory;

import naves.Carguero;
import naves.Combate;
import naves.Exploradora;
import naves.Nave;

public class NaveFactory {

    /**
     * Metodo que devuelve una nave dependiendo del tipo de nave que se le pase por parametro.
     * <b>PRE:</b> 
     * - tipoNave != null && !tipoNave.isEmpty()
     * 
     * @param tipoNave Tipo de nave (Carguero", "Combate", "Exploradora").
     * @return Una instancia de Nave correspondiente al tipo especificado, o null si el tipo no es válido.
     */
    public static Nave getNave(String tipoNave) {
        assert tipoNave != null && !tipoNave.isEmpty() : "El tipo de nave no puede ser nulo o vacío";
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
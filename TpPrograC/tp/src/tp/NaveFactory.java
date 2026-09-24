package tp;

public class NaveFactory {
    public Nave getNave(String tipoNave){
        switch (tipoNave){
            case "Carguero":
                return new Carguero();
            case "Combate":
                return new Combate();
            default:
                return new Exploradora();
        }
    }
}
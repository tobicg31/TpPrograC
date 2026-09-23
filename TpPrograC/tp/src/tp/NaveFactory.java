package tp;

public class NaveFactory {
    public Nave getNave(String tipoNave){
        switch (tipoNave){
            case "Carguero":
                return new Carguero();
                break;
            case "Combate":
                return new Combate();
                break;
            default:
                return new Exploradora();
        }
    }
}
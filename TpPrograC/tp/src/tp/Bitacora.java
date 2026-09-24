package tp;

import java.util.ArrayList;

public class Bitacora {
    private ArrayList<String> bitacora;

    public Bitacora() {
        this.bitacora = new ArrayList<String>();
    }

    public void agregarEntrada(String entrada){
        this.bitacora.add(entrada);
    }
}

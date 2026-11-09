package view;


import java.awt.event.ActionListener;
import model.destinoytablero.Tablero;
import model.elementosUniverso.ElementoDelUniverso;

public interface IVentanaTablero {

    
    void setActionListener(ActionListener listener);
    void mostrarError(String error);
    void limpiarError();
    int getX(); //filas
    int getY(); //columnas
    String getMision();//desplegable con las distintas misiones
}

package view;


import java.awt.event.ActionListener;

public interface IVentanaTablero {

    String Mision01 = "01";
    String Mision02 = "02";
    String Mision03 = "03";
    
    void setActionListener(ActionListener listener);
    void mostrarError(String error);
    void limpiarError();
    int getX(); //filas
    int getY(); //columnas
    String getMision();//desplegable con las distintas misiones
}

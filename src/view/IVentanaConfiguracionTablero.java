package view;

import java.awt.event.ActionListener;

public interface IVentanaConfiguracionTablero {
    String CREAR_TABLERO = "CREAR TABLERO";
    String VOLVER = "VOLVER CONFIGURACION";

    void setActionListener(ActionListener listener);
    int getAncho();
    int getAlto();
    int getCantidadObstaculos();
    int getCantidadNavesEnemigas();
    int getCantidadAyudas();
    void mostrarError(String error);
    void arranca();
    void cierra();
}

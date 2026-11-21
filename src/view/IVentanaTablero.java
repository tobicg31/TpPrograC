package view;

import java.awt.event.ActionListener;
import java.util.List;

import model.bitacoras.EventoBitacora;
import model.destinoytablero.Observador;
import model.destinoytablero.Tablero;

public interface IVentanaTablero extends Observador {
    String Mision01 = "01";
    String Mision02 = "02";
    String Mision03 = "03";
    String INICIAR_MISION = "INICIAR MISION";
    String VOLVER = "VOLVER CONTROL";

    void setActionListener(ActionListener listener);
    int getFilasTablero();
    int getColumnasTablero();
    String getMision();
    void observarTablero(Tablero tablero);
    void mostrarRecursos(String tipoNave, int combustible, int energia, int desgaste, String estadoMotor);
    void mostrarEventos(List<EventoBitacora> eventos);
    void mostrarInformes(List<EventoBitacora> informes);
    void setMisionActiva(boolean activa);
    void mostrarError(String error);
    void limpiarError();
    void arranca();
    void cierra();
}

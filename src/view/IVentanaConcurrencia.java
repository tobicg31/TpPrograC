
package view;

import java.awt.event.ActionListener;

import model.concurrencia.ObserverPlataforma;

public interface IVentanaConcurrencia extends ObserverPlataforma {
    String EJECUTAR = "EJECUTAR";
    String CREAR_NAVE = "CREAR NAVE";
    String CREAR_GENERADOR = "CREAR GENERADOR";
    String VOLVER = "VOLVER";

    void setActionListener(ActionListener listener);

    boolean validaParametros();

    void agregarNave(String string);

    void agregarGenerador(String string);

    void arranca();

    void cierra();

}

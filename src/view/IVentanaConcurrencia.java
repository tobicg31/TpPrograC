
package view;
import java.awt.event.ActionListener;

import model.concurrencia.ObserverPlataforma;

public interface IVentanaConcurrencia extends ObserverPlataforma {


    public void setActionListener(ActionListener listener);
    public boolean validaParametros();

    public void agregarNave(String string);
    public void agregarGenerador(String string);
    
}


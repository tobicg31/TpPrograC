
package concurrencia;

import java.util.Observable;

/**
 * Esta clase representa una plataforma de carga que permite la generación y consumo de energía de manera concurrente.
 * Implementa dos métodos synchronized para garantizar que los generadores y consumidores puedan operar de manera dinámica.
 */

public class PlataformaDeCarga extends Observable{
    private int cantbat = 0, topedeposito; // Cantidad de baterías disponibles en la plataforma
    

    /**
     * Constructor de la clase PlataformaDeCarga.
     * 
     * @param topedeposito El límite máximo de baterías que la plataforma puede almacenar. topedeposito>0
     */
    public PlataformaDeCarga(int topedeposito) {
        this.topedeposito = topedeposito;
    }
    //TODOS LOS SYSTEM.OUT.PRINTLN DEBEN SER LANZADOS POR PATRON OBSERVER

   public synchronized void generarEnergia(int id) {
       while(cantbat == topedeposito) {
            try {
                wait(); // Espera hasta que haya espacio disponible en la plataforma
                clearChanged(); // cant bat no cambia por "alguna razon", no se notifica a los observadores
                notifyObservers();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.cantbat++;
        setChanged();
        notifyObservers(); // Notifica a los observadores que la cantidad de baterías ha cambiado
        //System.out.println("Batería producida por [Generadora " + id + "]. Total disponible: " + this.cantbat);
        notifyAll(); // Notifica a los hilos 
    }

    public synchronized void consumirEnergia(int id) {
        while (cantbat == 0) {
            try {
                wait(); // Espera hasta que haya energía disponible
                clearChanged(); // cant bat no cambia por "alguna razon", no se notifica a los observadores
                notifyObservers();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.cantbat--;
        setChanged();
        notifyObservers(); // Notifica a los observadores que la cantidad de baterías ha cambiado
       // System.out.println("Batería retirada y utilizada por [Nave " + id + "]. Total disponible: " + this.cantbat);
        notifyAll(); // Notifica a los hilos 
    }

}

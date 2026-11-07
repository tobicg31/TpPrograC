
package model.concurrencia;

import java.util.ArrayList;



/**
 * Esta clase representa una plataforma de carga que permite la generación y consumo de energía de manera concurrente.
 * Implementa dos métodos synchronized para garantizar que los generadores y consumidores puedan operar de manera dinámica.
 */

public class PlataformaDeCarga{
    private int cantbat = 0;
    private final int topedeposito; // Cantidad de baterías disponibles en la plataforma
    private ArrayList<ObserverPlataforma> observadores = new ArrayList<>();

    /**
     * Constructor de la clase PlataformaDeCarga.
     * 
     * @param topedeposito El límite máximo de baterías que la plataforma puede almacenar. topedeposito>0
     */
    public PlataformaDeCarga(int topedeposito) {
        this.topedeposito = topedeposito;
        this.observadores = new ArrayList<>();
    }
    //TODOS LOS SYSTEM.OUT.PRINTLN DEBEN SER LANZADOS POR PATRON OBSERVER

   public synchronized void generarEnergia(int id) {
       while(cantbat == topedeposito) {
            try {
                wait(); // Espera hasta que haya espacio disponible en la plataforma
                notificarObservadores("[Generadora " + id + "] esperando a que se libere espacio en la Plataforma");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.cantbat++;
        notificarObservadores("Batería producida por [Generadora " + id + "]. Total disponible: " + this.cantbat);
        notifyAll(); // Notifica a los hilos 
    }

    public synchronized void consumirEnergia(int id) {
        while (cantbat == 0) {
            try {
                wait(); // Espera hasta que haya energía disponible
                notificarObservadores("[Nave " + id + "] esperando por falta de baterías en la Plataforma."); 
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        this.cantbat--;
        notificarObservadores("Batería retirada y utilizada por [Nave " + id + "]. Total disponible: " + this.cantbat);
        notifyAll(); // Notifica a los hilos 
    }

    public int getCantbat() {
        return cantbat;
    }

    public int getTopedeposito() {
        return topedeposito;
    }
 // ---------- Observable ----------
    public void agregarObservador(ObserverPlataforma o) {
        observadores.add(o);
    }

    public void quitarObservador(ObserverPlataforma o) {
        observadores.remove(o);
    }
     public void notificarObservadores(String evento) {
        for (ObserverPlataforma o : observadores) {
            o.actualizar(evento); 
        }
    }
}



package model.concurrencia;

/**
 *Esta clase representa un generador de energía (productor) que se ejecuta en un hilo separado. 
 * Implementa la interfaz Runnable para permitir su ejecución concurrente.
 */
public class GeneradoradeEnergia implements Runnable {
    
    private final int id;
    private final PlataformaDeCarga plataforma;

    public GeneradoradeEnergia(int id, PlataformaDeCarga plataforma) {
        this.id = id;
        this.plataforma = plataforma;
    }

    @Override
    public void run(){

            try {
                Thread.sleep((int) (Math.random() * 2000)); // Simula el tiempo que tarda en generar energía nuevamente
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            plataforma.generarEnergia(this.id);
    }
}

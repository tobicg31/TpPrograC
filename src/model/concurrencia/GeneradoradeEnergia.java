
package model.concurrencia;

/**
 *Esta clase representa un generador de energía (productor) que se ejecuta en un hilo separado. 
 * Implementa la interfaz Runnable para permitir su ejecución concurrente.
 */
public class GeneradoradeEnergia implements Runnable {
    
    private int id;//, cantidadEnergiaGenerada;???
    private PlataformaDeCarga plataforma;

    public GeneradoradeEnergia(int id, PlataformaDeCarga plataforma, int cantidadEnergiaGenerada) {
        this.id = id;
       // this.cantidadEnergiaGenerada = cantidadEnergiaGenerada;
        this.plataforma = plataforma;
    }

    @Override
    public void run(){
       /* int i;
        for (i = 0; i < cantidadEnergiaGenerada; i++) {*/
             plataforma.generarEnergia(this.id);

            try {
                Thread.sleep((int) (Math.random() * 100)); // Simula el tiempo que tarda en generar energía nuevamente
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
    
        /*}  */
            }

    }
}

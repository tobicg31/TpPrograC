package model.concurrencia;

/**
 * Esta clase representa una nave consumidora (consumidor) que se ejecuta en un hilo separado.
 * Implementa la interfaz Runnable para permitir su ejecución concurrente.
 * 
 */
public class NaveConsumidora implements Runnable {
    private int id;
    private PlataformaDeCarga plataforma;

    public NaveConsumidora(int id, PlataformaDeCarga plataforma) {
        this.id = id;
        this.plataforma = plataforma;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000)); // Simula el tiempo que tarda en consumir energía nuevamente
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        plataforma.consumirEnergia(this.id);
    }

}

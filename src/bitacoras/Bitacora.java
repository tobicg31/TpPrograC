package bitacoras;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Esta clase representa la Bitacora que se utiliza para registrar los eventos,
 * resultados y errores a lo largo de la nave.
 * 
 * <b>Invariante de clase:</b>
 * - bitacora != null luego de completarse la inicialización.
 * 
 */
public class Bitacora {
    private ArrayList<EventoBitacora> bitacora;

    public Bitacora() {
        this.bitacora = new ArrayList<EventoBitacora>();
        assert this.bitacora != null : "La bitácora no puede ser nulla";
    }

    /**
     * Este método permite agregar una entrada a la bitácora con un mensaje y un
     * tipo de evento.
     * <b>PRE:</b>
     * - mensaje != null && !mensaje.isEmpty()
     * - tipo != null && !tipo.isEmpty()
     * 
     * @param mensaje Este parámetro representa el mensaje que se desea registrar en
     *                la bitácora.
     * @param tipo    Este parámetro representa el tipo de evento que se desea
     *                registrar en la bitácora.
     */
    public void agregarEntrada(String mensaje, String tipo) {
        assert this.bitacora != null : "La bitácora no puede ser nulla";
        assert mensaje != null : "El mensaje no puede ser nulo";
        assert tipo != null : "El tipo no puede ser nulo";
        EventoBitacora entrada = new EventoBitacora(mensaje, tipo);
        this.bitacora.add(entrada);
    }

    /**
     * Este método permite consultar la bitácora y mostrar todas las entradas
     * registradas en ella.
     * 
     * @return Las entradas se muestran ordenadas por fecha, desde la más antigua
     *         hasta la más reciente.
     */
    public void consultarBitacora() {
        assert this.bitacora != null : "La bitácora no puede ser nulla";
        System.out.println("Bitacora:");
        ArrayList<EventoBitacora> bitacoraOrdenada = (ArrayList<EventoBitacora>) this.bitacora.clone();
        bitacoraOrdenada.sort(Comparator.comparing(EventoBitacora::getFecha));
        for (EventoBitacora entrada : bitacoraOrdenada) {
            System.out.println(entrada.getFecha() + " - " + entrada.getTipo() + ": " + entrada.getMensaje());
        }
    }
}

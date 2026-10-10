import asistentes.Asistente;
import java.util.ArrayList;

/**
 * Esta clase representa lo que sería la capa de negocio del problema.
 */
public class Sistema {
    private ArrayList<Asistente> asistentes = new ArrayList<Asistente>();

    /**
     * Este método permite registrar un asistente en el sistema.
     * <b>PRE:</b>
     * - asistente != null
     * 
     * @param asistente Este parámetro representa el asistente que se desea
     *                  registrar.
     * 
     * <b>POST:</b>
     *  - Asistente está registrado en el sistema.
     */
    public void registrarAsistente(Asistente asistente) {
        assert asistente != null : "El asistente no puede ser nulo";
        this.asistentes.add(asistente);
        System.out.println("Asistente registrado en el sistema.");
    }

    /**
     * Este método permite obtener la lista de asistentes registrados en el sistema.
     * 
     * @return Una lista con los asistentes registrados.
     */
    public ArrayList<Asistente> getAsistentesDeNaves() {
        return this.asistentes;
    }

}

package bitacoras;

import java.time.LocalDate;

/**
 * Esta clase representa el contenido que tendrá la Bitacora.
 *  
 * <b>Invariantes de clase:</b>
 * - mensaje != null luego de completarse la inicialización.
 * - tipo != null luego de completarse la inicialización.
 * - fecha != null luego de completarse la inicialización.
 * 
 */
public class EventoBitacora {
  private String mensaje, tipo;
  private LocalDate fecha;

  /**
   * Constructor de la clase EventoBitacora.
   * <b>PRE:</b>
   * - mensaje != null && !mensaje.isEmpty()
   * - tipo != null && !tipo.isEmpty()
   * 
   * @param mensaje Mensaje del evento de la bitácora.
   * @param tipo    Tipo del evento de la bitácora.
   */
  public EventoBitacora(String mensaje, String tipo) {
    assert mensaje != null : "El mensaje no puede ser nulo";
    assert tipo != null : "El tipo no puede ser nullo";
    this.mensaje = mensaje;
    this.tipo = tipo;
    this.fecha = LocalDate.now();
    assert this.fecha != null : "La fecha no puede ser nula";
  }

  public String getMensaje() {
    return mensaje;
  }

  public String getTipo() {
    return tipo;
  }

  public LocalDate getFecha() {
    return fecha;
  }
}
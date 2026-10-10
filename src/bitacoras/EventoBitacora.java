package bitacoras;

import java.time.LocalDate;

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
   * @param tipo Tipo del evento de la bitácora.
   */
  public EventoBitacora(String mensaje, String tipo) {
    this.mensaje = mensaje;
    this.tipo = tipo;
    this.fecha = LocalDate.now();
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
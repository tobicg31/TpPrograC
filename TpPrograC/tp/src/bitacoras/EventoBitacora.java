package bitacoras;

import java.time.LocalDate;

public class EventoBitacora {
  private String mensaje, tipo;
  private LocalDate fecha;

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
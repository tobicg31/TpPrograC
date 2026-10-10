package misiones.factory;

import misiones.Mision;
import misiones.Mision01;
import misiones.Mision02;
import misiones.Mision03;

public class MisionFactory {

  /**
   * Método que devuelve una instancia de Mision según el tipo de misión.
   * <b>PRE:</b> 
   * - tipoMision != null && !tipoMision.isEmpty()
   *
   * @param tipoMision El tipo de misión ("01", "02", "03").
   * @return Una instancia de Mision correspondiente al tipo especificado, o null si el tipo no es válido.
   */
  public static Mision getMision(String tipoMision) {
    assert tipoMision != null && !tipoMision.isEmpty() : "El tipo de mision no puede ser nulo o vacío";
    switch (tipoMision) {
      case "01":
        return new Mision01();
      case "02":
        return new Mision02();
      case "03":
        return new Mision03();
      default:
        return null;
    }
  }
}

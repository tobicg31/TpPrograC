package model.misiones.factory;

import model.destinoytablero.Destino;
import model.destinoytablero.Tablero;
import model.misiones.Mision;
import model.misiones.Mision01;
import model.misiones.Mision02;
import model.misiones.Mision03;

/**
 * Esta clase es una fábrica de misiones que proporciona un método para obtener
 * instancias de misiones según el tipo especificado.
 */
public class MisionFactory {

  /**
   * Método que devuelve una instancia de Mision según el tipo de misión.
   * <b>PRE:</b>
   * - tipoMision != null && !tipoMision.isEmpty()
   *
   * @param tipoMision El tipo de misión ("01", "02", "03").
   * @return Una instancia de Mision correspondiente al tipo especificado, o null
   *         si el tipo no es válido.
   */
  public static Mision getMision(String tipoMision, Tablero t, Destino d) {
    assert tipoMision != null && !tipoMision.isEmpty() : "El tipo de mision no puede ser nulo o vacío";
    switch (tipoMision) {
      case "01":
        return new Mision01(t,d);
      case "02":
        return new Mision02(t,d);
      case "03":
        return new Mision03(t,d);
      default:
        return null;
    }
  }
}

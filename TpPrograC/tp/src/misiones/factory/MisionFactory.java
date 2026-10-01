package misiones.factory;

import misiones.Mision;
import misiones.Mision01;
import misiones.Mision02;
import misiones.Mision03;

public class MisionFactory {
  public static Mision getMision(String tipoMision) {
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

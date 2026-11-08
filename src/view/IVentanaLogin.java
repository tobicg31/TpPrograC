package view;

import java.awt.event.ActionListener;

public interface IVentanaLogin {
  String LOGIN = "LOGIN";
  String REGISTRAR = "REGISTRAR";

  void setActionListener(ActionListener listener);
  void mostrarError(String error);
  void limpiarCampos();
  void limpiarError();
  String getUsuario();
  String getContrasenia();
  void arranca();
  void cierra();
}

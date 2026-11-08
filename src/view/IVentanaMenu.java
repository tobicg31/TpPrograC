package view;

import java.awt.event.ActionListener;

import model.acceso.Usuario;

public interface IVentanaMenu {
  String VISTA_CREACION = "VISTA CREACION";
  String VISTA_CONTROL = "VISTA CONTROL";
  String VISTA_CONCURRENCIA = "VISTA CONCURRENCIA";
  String CERRAR_SESION = "CERRAR SESION";

  void setActionListener(ActionListener listener);

  void arranca(Usuario usuario);

  void cierra();
}

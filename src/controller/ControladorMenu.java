package controller;

import view.IVentanaConcurrencia;
import view.IVentanaConfiguracionTablero;
import view.IVentanaCreacion;
import view.IVentanaLogin;
import view.IVentanaMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenu implements ActionListener {
  private IVentanaMenu vistaMenu;
  private IVentanaCreacion vistaCreacion;
  private IVentanaLogin vistaLogin;
  private IVentanaConcurrencia vistaConcurrencia;
  private IVentanaConfiguracionTablero vistaConfiguracionTablero;
  private ControladorCreacion controladorCreacion;
  private ControladorTablero controladorTablero;

  public ControladorMenu(IVentanaMenu vistaMenu, IVentanaCreacion vistaCreacion, IVentanaLogin vistaLogin,
      IVentanaConcurrencia vistaConcurrencia, IVentanaConfiguracionTablero vistaConfiguracionTablero) {
    this(vistaMenu, vistaCreacion, vistaLogin, vistaConcurrencia, vistaConfiguracionTablero, null, null);
  }

  public ControladorMenu(IVentanaMenu vistaMenu, IVentanaCreacion vistaCreacion, IVentanaLogin vistaLogin,
      IVentanaConcurrencia vistaConcurrencia, IVentanaConfiguracionTablero vistaConfiguracionTablero,
      ControladorCreacion controladorCreacion) {
    this(vistaMenu, vistaCreacion, vistaLogin, vistaConcurrencia, vistaConfiguracionTablero, controladorCreacion, null);
  }

  public ControladorMenu(IVentanaMenu vistaMenu, IVentanaCreacion vistaCreacion, IVentanaLogin vistaLogin,
      IVentanaConcurrencia vistaConcurrencia, IVentanaConfiguracionTablero vistaConfiguracionTablero,
      ControladorCreacion controladorCreacion, ControladorTablero controladorTablero) {
    this.vistaMenu = vistaMenu;
    this.vistaCreacion = vistaCreacion;
    this.vistaLogin = vistaLogin;
    this.vistaConcurrencia = vistaConcurrencia;
    this.vistaConfiguracionTablero = vistaConfiguracionTablero;
    this.controladorCreacion = controladorCreacion;
    this.controladorTablero = controladorTablero;
    this.vistaMenu.setActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
      case IVentanaMenu.VISTA_CREACION:
        vistaMenu.cierra();
        vistaCreacion.arranca();
        break;
      case IVentanaMenu.VISTA_CONTROL:
        if (this.controladorCreacion != null && this.controladorCreacion.getNave() == null) {
          this.vistaMenu.mostrarAdvertencia("Primero debe instanciar una nave en la vista de Creación.");
          break;
        }
        vistaMenu.cierra();
        vistaConfiguracionTablero.arranca();
        break;
      case IVentanaMenu.VISTA_CONCURRENCIA:
        vistaMenu.cierra();
        vistaConcurrencia.arranca();
        break;
      case IVentanaMenu.CERRAR_SESION:
        if (this.controladorCreacion != null) {
          this.controladorCreacion.resetear();
        }
        if (this.controladorTablero != null) {
          this.controladorTablero.resetear();
        }
        vistaMenu.cierra();
        vistaLogin.arranca();
        vistaLogin.limpiarCampos();
        vistaLogin.limpiarError();
        break;
    }
  }
}

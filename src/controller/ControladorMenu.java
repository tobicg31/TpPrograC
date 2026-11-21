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

  public ControladorMenu(IVentanaMenu vistaMenu, IVentanaCreacion vistaCreacion, IVentanaLogin vistaLogin,
      IVentanaConcurrencia vistaConcurrencia, IVentanaConfiguracionTablero vistaConfiguracionTablero) {
    this.vistaMenu = vistaMenu;
    this.vistaCreacion = vistaCreacion;
    this.vistaLogin = vistaLogin;
    this.vistaConcurrencia = vistaConcurrencia;
    this.vistaConfiguracionTablero = vistaConfiguracionTablero;
    this.vistaMenu.setActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    vistaMenu.cierra();
    
    switch(e.getActionCommand()) {
      case IVentanaMenu.VISTA_CREACION:
				vistaCreacion.arranca();
				break;
			case IVentanaMenu.VISTA_CONTROL:
			  vistaConfiguracionTablero.arranca();
				break;
      case IVentanaMenu.VISTA_CONCURRENCIA:
				vistaConcurrencia.arranca();
				break;
      case IVentanaMenu.CERRAR_SESION:
        vistaLogin.arranca();
        vistaLogin.limpiarCampos();
        vistaLogin.limpiarError();
        break;
    }
  }
}

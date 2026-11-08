package controller;

import view.IVentanaConcurrencia;
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

  public ControladorMenu(IVentanaMenu vistaMenu, IVentanaCreacion vistaCreacion, IVentanaLogin vistaLogin, IVentanaConcurrencia vistaConcurrencia) {
    this.vistaMenu = vistaMenu;
    this.vistaCreacion = vistaCreacion;
    this.vistaLogin = vistaLogin;
    this.vistaConcurrencia = vistaConcurrencia;
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

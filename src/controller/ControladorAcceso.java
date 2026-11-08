package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.IVentanaLogin;

public class ControladorAcceso implements ActionListener {
    private final IVentanaLogin vista;

    public ControladorAcceso(IVentanaLogin vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vista.limpiarError();

        switch (e.getActionCommand()) {
            case IVentanaLogin.LOGIN:
                loginCuenta();
                break;
            case IVentanaLogin.REGISTRAR:
                registrarCuenta();
                break;
        }
    }

    private void loginCuenta() {

    }

    private void registrarCuenta() {

    }
}
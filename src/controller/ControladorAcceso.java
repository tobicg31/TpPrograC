package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.acceso.Usuario;
import model.acceso.UsuarioDAO;
import view.IVentanaLogin;
import view.IVentanaMenu;

public class ControladorAcceso implements ActionListener {
    private final IVentanaLogin vista;
    private final IVentanaMenu vistaMenu;
    private final UsuarioDAO usuarioDAO;

    public ControladorAcceso(IVentanaLogin vista, IVentanaMenu vistaMenu, UsuarioDAO usuarioDAO) {
        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.usuarioDAO = usuarioDAO;
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
        Usuario usuario = obtenerUsuarioValidado();
        if (usuario == null) {
            return;
        }

        try {
            if (usuarioDAO.iniciarSesion(usuario)) {
                vista.mostrarMensaje("Inicio de sesión exitoso.");
                vista.cierra();
                vistaMenu.arranca(usuario);
            } else {
                vista.mostrarError("Usuario o contraseña incorrectos.");
            }
        } catch (SQLException e) {
            vista.mostrarError("Error al consultar la base de datos: " + e.getMessage());
        }
    }

    private void registrarCuenta() {
        Usuario usuario = obtenerUsuarioValidado();
        if (usuario == null) {
            return;
        }

        try {
            if (usuarioDAO.crearUsuario(usuario)) {
                vista.limpiarCampos();
                vista.mostrarMensaje("Cuenta creada. Ya podés iniciar sesión.");
            } else {
                vista.mostrarError("Ese nombre de usuario ya está registrado.");
            }
        } catch (SQLException e) {
            vista.mostrarError("Error al guardar el usuario: " + e.getMessage());
        }
    }

    private Usuario obtenerUsuarioValidado() {
        String nombreUsuario = vista.getUsuario().trim();
        String contrasenia = vista.getContrasenia();
        if (nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
            vista.mostrarError("Por favor, complete todos los campos.");
            return null;
        }
        if (nombreUsuario.length() < 6 || contrasenia.length() < 6) {
            vista.mostrarError("El nombre de usuario y la contraseña deben tener al menos 6 caracteres.");
            return null;
        }
        if (nombreUsuario.length() > 20) {
            vista.mostrarError("El nombre de usuario no puede superar los 20 caracteres.");
            return null;
        }
        return new Usuario(nombreUsuario, contrasenia);
    }
}
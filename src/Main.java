import java.awt.EventQueue;
import java.nio.file.Path;

import controller.ControladorAcceso;
import controller.ControladorConcurrencia;
import controller.ControladorCreacion;
import controller.ControladorMenu;
import controller.ControladorTablero;
import model.acceso.UsuarioDAOSql;
import model.concurrencia.PlataformaDeCarga;
import view.VentanaConcurrencia;
import view.VentanaConfiguracionTablero;
import view.VentanaControlNave;
import view.VentanaCreacion;
import view.VentanaLogin;
import view.VentanaMenu;

/**
 * Punto de entrada de la aplicación gráfica.
 */
public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            VentanaLogin ventanaLogin = new VentanaLogin();
            VentanaMenu ventanaMenu = new VentanaMenu();
            VentanaCreacion ventanaCreacion = new VentanaCreacion();
            VentanaConcurrencia ventanaConcurrencia = new VentanaConcurrencia();
            VentanaConfiguracionTablero ventanaConfiguracionTablero = new VentanaConfiguracionTablero();
            VentanaControlNave ventanaControlNave = new VentanaControlNave();

            ControladorCreacion controladorCreacion = new ControladorCreacion(ventanaCreacion, ventanaMenu);
            new ControladorConcurrencia(ventanaConcurrencia, ventanaMenu, new PlataformaDeCarga(3));
            ControladorTablero controladorTablero = new ControladorTablero(ventanaConfiguracionTablero,
                    ventanaControlNave, ventanaMenu, controladorCreacion);
            new ControladorMenu(ventanaMenu, ventanaCreacion, ventanaLogin, ventanaConcurrencia,
                    ventanaConfiguracionTablero, controladorCreacion, controladorTablero);
            new ControladorAcceso(ventanaLogin, ventanaMenu, new UsuarioDAOSql(Path.of("usuarios.db")));

            ventanaLogin.arranca();
        });
    }
}

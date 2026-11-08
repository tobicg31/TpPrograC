package model.acceso;

import java.sql.SQLException;

public interface UsuarioDAO {
    boolean crearUsuario(Usuario usuario) throws SQLException;

    boolean iniciarSesion(Usuario usuario) throws SQLException;
} 

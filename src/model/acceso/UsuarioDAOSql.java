package model.acceso;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAOSql implements UsuarioDAO {
    private final Path archivo;
    private boolean baseInicializada = false;

    public UsuarioDAOSql(Path archivo) {
        this.archivo = archivo.toAbsolutePath();
    }

    @Override
    public boolean crearUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nomUsuario, contraseña) VALUES (?,?)";
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenia());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 19) {
                return false;
            }
            throw e;
        }
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) throws SQLException {
        String sql = "SELECT 1 FROM usuarios WHERE nomUsuario = ? AND contraseña = ?";
        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasenia());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    private Connection conectar() throws SQLException {
        try {
            Files.createDirectories(archivo.getParent());
        } catch (java.io.IOException e) {
            throw new SQLException("No se pudo crear el directorio de la base de datos.", e);
        }

        Connection con = DriverManager.getConnection("jdbc:sqlite:" + archivo);
        try {
            if (!baseInicializada) {
                inicializarBase(con);
                baseInicializada = true;
            }
            return con;
        } catch (SQLException e) {
            con.close();
            throw e;
        }
    }

    private void inicializarBase(Connection con) throws SQLException {
        try (InputStream in = UsuarioDAOSql.class.getResourceAsStream("/init.sql")) {
            if (in == null) {
                throw new SQLException("No se encontró init.sql en el classpath");
            }
            String script = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            for (String sentencia : script.split(";")) {
                if (!sentencia.isBlank()) {
                    try (PreparedStatement ps = con.prepareStatement(sentencia)) {
                        ps.executeUpdate();
                    }
                }
            }
        } catch (java.io.IOException e) {
            throw new SQLException("No se pudo leer init.sql", e);
        }
    }
}

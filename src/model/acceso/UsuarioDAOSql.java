package model.acceso;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAOSql implements UsuarioDAO{
    private static final String COLUMNAS = "id, nomUsuario, contraseña";

    private final String url;
    private boolean baseInicializada = false;


    public UsuarioDAOSql(Path archivo) {
        this.url = "jdbc:sqlite:" + archivo;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nomUsuario, contraseña) VALUES (?,?)" ;
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1,usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        String sql = "SELECT " + COLUMNAS + " FROM usuarios WHERE nomUsuario = ? AND contraseña = ?";
        
        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            
            try (ResultSet rs = ps.executeQuery()) {
                // Si rs.next() es true, el usuario existe y las credenciales coinciden
                return rs.next(); 
            }
            
        } catch (SQLException e) {
            
        }
        return false; // Retorna falso si hay un error o si el usuario no existe
    }

    private Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(url);
        if (!baseInicializada) {
            inicializarBase(con);
            baseInicializada = true;
        }
        return con;
    }

    private void inicializarBase(Connection con) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(
                "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'usuarios'");
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return;
            }
        }
        try (Statement st = con.createStatement()) {
            for (String sentencia : leerScriptInicial().split(";")) {
                if (!sentencia.isBlank()) {
                    st.executeUpdate(sentencia);
                }
            }
        }
    }

    private String leerScriptInicial() throws SQLException {
        try (InputStream in = UsuarioDAOSql.class.getResourceAsStream("/init.sql")) {
            if (in == null) {
                throw new SQLException("No se encontró init.sql en el classpath");
            }
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new SQLException("No se pudo leer init.sql", e);
        }
    }

    
}

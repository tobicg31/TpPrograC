package model.acceso;

public interface UsuarioDAO {
    public void crearUsuario(Usuario usuario);
    public boolean iniciarSesion(Usuario usuario);    
} 

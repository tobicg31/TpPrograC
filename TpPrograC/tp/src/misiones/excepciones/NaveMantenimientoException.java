package misiones.excepciones;

public class NaveMantenimientoException extends Exception {
    public NaveMantenimientoException(String m){
        super(m);
    }
    public NaveMantenimientoException(){
        super("La nave requiere mantenimiento");
    }
}


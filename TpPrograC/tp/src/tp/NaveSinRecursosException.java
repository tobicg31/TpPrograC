package tp;

public class NaveSinRecursosException extends Exception {
    public NaveSinRecursosException(String m){
        super(m);
    }
    public NaveSinRecursosException(){
        super("Fallo de recursos");
    }
}

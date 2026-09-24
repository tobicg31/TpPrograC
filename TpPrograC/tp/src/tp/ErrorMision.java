package tp;

public class ErrorMision extends Exception {
    public ErrorMision(String m){
        super(m);
    }
    public ErrorMision(){
        super("Fallo de recursos");
    }
}

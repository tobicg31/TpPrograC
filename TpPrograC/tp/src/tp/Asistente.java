package tp;

public class Asistente {
    private Nave nave;

    public Asistente(Nave n) {
        this.nave = n;
    }
    public void ejecutarMision(Mision mision){
        mision.ejecutar(this.nave);
    }


}

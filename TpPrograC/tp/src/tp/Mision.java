package tp;

public abstract class Mision { //preguntar que hace bien cada mision y el paso a paso
    

    public void preparar(Nave n){
        System.out.println("preparo la nave...");
        
    }
    public abstract void ejecutar(Nave n);

    public abstract void evaluar(Nave n);

    public void cerrar(Nave n){
    }
}

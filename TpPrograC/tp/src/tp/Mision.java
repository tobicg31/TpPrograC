package tp;

public abstract class Mision { //preguntar que hace bien cada mision y el paso a paso
    

    public void preparar(Nave n){
        System.out.println("preparo la nave...");
    }
    public void ejecutar(Nave n){

    }
    public void evaluar(Nave n){
        /*
        n.setCombustible() = n.getCombustible()-4;
        n.setDesgaste() = n.setDesgaste()+4;
        */
    }
    public void cerrar(Nave n){
        //aca iria el informe, creo(?
    }
}

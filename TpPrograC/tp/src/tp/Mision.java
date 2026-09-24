package tp;

public abstract class Mision { //preguntar que hace bien cada mision y el paso a paso
    

    public void preparar(Nave n)throws NaveSinRecursosException{
        System.out.println("preparo la nave...");
        if (!((n.getCombustible() - 4 > 0) && (n.getDesgaste() + 4 < 100))){
            throw new ErrorMision("Fallo de recursos"); 
            //revisar motor tambien, con su excepcion
        }
        else
            System.out.println("Nave preparada!");
    }

    public void ejecutar(Nave n){
        n.setCombustible( n.getCombustible() - 4);
        n.setDesgaste(n.getDesgaste() + 4);        
    }

    public abstract void evaluar(Nave n);//fecha, recursos, que hizo

    public void cerrar(Nave n){
    }

    public void ejecutarMision(Nave n) {
        try{
            preparar(n);
            ejecutar(n);
            evaluar(n);
            cerrar(n);
        }
        catch(NaveSinRecursosException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

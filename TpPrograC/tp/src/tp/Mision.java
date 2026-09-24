package tp;

public abstract class Mision { //preguntar que hace bien cada mision y el paso a paso
    

    public void preparar(Nave n)throws NaveSinRecursosException{
        System.out.println("preparo la nave...");
        if (!((n.getCombustible() - 4 > 0) && (n.getDesgaste() + 4 < 100))){
<<<<<<< HEAD
            throw new ErrorMision("Fallo de recursos"); 
            //revisar motor tambien, con su excepcion
=======
            throw new NaveSinRecursosException("Fallo de recursos");
>>>>>>> 9a26559e7da3b0442642d85376e3d50ce20e6982
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

package tp;

public class Consejero extends Tripulante {
   // private int cantidadconsejos; ???
    public Consejero(String id,String cargo,String planeta,int antiguedad) {
         if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID no puede ser nulo ni vacío.");
        }
        if (cargo == null || planeta == null) {
            throw new IllegalArgumentException("Cargo y planeta son obligatorios.");
        }
        if (antiguedad < 0) {
            throw new IllegalArgumentException("La antigüedad no puede ser negativa.");
        }
        this.identidad=id;
        this.cargo="Consejero";
        this.planeta=planeta;
        this.antiguedad=antiguedad;
        this.porcentadicional=5/100;
    }
       // cantidadconsejos=0;
    

   /*} public void nuevoconsejo() {
        this.cantidadconsejos++;
    }

    public int getcantidadconsejos() {
        return cantidadconsejos;
    }
    */
   @Override
    public double liquidaciondehaberes(){
        return 600;
    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo:"+this.liquidaciondehaberes());

    }

}

package tp;

public class Teniente extends Tripulante {
    public Teniente(String id,String cargo,String planeta,int antiguedad) {
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
        this.cargo="Teniente";
        this.planeta=planeta;
        this.antiguedad=antiguedad;
         this.porcentadicional=3/100;
    }
    

    @Override
    public double liquidaciondehaberes(){
        return 400;
    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo:"+this.liquidaciondehaberes());

    }
}
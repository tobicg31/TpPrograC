package tp;

public class Capitan extends Tripulante {
    public Capitan(String id,String planeta,int antiguedad) {
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
        this.cargo="Capitan";
        this.planeta=planeta;
        this.antiguedad=antiguedad;
        this.porcentadicional=20/100;
    }

    @Override
    public double liquidaciondehaberes(){
        return 1000;

    }
    @Override
    public String descripcionhaberes(){
        return ("Correspondiente al cargo:"+this.liquidaciondehaberes());

    }
}
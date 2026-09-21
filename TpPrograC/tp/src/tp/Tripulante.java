package tp;

public abstract class Tripulante {
    private String identidad, cargo, planeta;
    private int antiguedad;
    
    public Tripulante(String id,String cargo,String planeta,int antiguedad) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del tripulante no puede ser nulo ni vacío.");
        }
        if (cargo == null || planeta == null) {
            throw new IllegalArgumentException("El cargo y planeta son obligatorios.");
        }
        if (antiguedad < 0) {
            throw new IllegalArgumentException("La antigüedad no puede ser negativa.");
        }

        this.identidad=id;
        this.cargo=cargo;
        this.planeta=planeta;
        this.antiguedad=antiguedad;
    }

    public String getIdentidad() {
        return identidad;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPlaneta() {
        return planeta;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String tooString(){
        return (this.identidad+": Cargo:"+this.cargo+" |Planeta:"+this.planeta+" |Antiguedad:"+this.antiguedad);
        
    }
}

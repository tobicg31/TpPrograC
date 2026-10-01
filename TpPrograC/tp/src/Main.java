public class Main {
    public static void Main(String [] args){
       String tipo = "Combate"; 
       Nave nave = NaveFactory.getNave(tipo);  
       Asistente asistente = new Asistente(nave); 
       Sistema.registrarAsistente(asistente);
       
       asistente.ejecutarMision(mision, asistente.getNave());


    }
}
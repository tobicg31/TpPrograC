import asistentes.Asistente;
import bitacoras.Bitacora;
import misiones.Mision;
import naves.Nave;
import naves.factory.NaveFactory;
import tripulantes.Alferez;
import tripulantes.Capitan;
import tripulantes.Consejero;
import tripulantes.Teniente;
import tripulantes.decorator.Liquidable;
import tripulantes.decorator.Marciano;
import tripulantes.decorator.Terricola;
import tripulantes.decorator.Vulcano;

public class Main {
    public static void main(String [] args){
       Nave nave = NaveFactory.getNave("Combate"); 
       Asistente asistente = new Asistente(nave); 
       Sistema.registrarAsistente(asistente);
       System.out.println("--- INICIO: Estado Inicial ---");


       nave.getMotor().prepararSalto(); 
       nave.getMotor().saltar();         
       nave.getMotor().pasaTiempo();
       
       nave.getMotor().prepararSalto();        
       nave.getMotor().pasaTiempo();
 
       Mision m1 = MisionFactory.getMision("01");
       asistente.ejecutarMision(m1, nave);
       Bitacora bitacora = asistente.getBitacora(nave);
       bitacora.consultarBitacora();

       Mision m2 = MisionFactory.getMision("02");
       asistente.ejecutarMision(m2, nave);
       Bitacora bitacora = asistente.getBitacora(nave);
       bitacora.consultarBitacora();

       Mision m3 = MisionFactory.getMision("03");
       asistente.ejecutarMision(m3, nave);
       Bitacora bitacora = asistente.getBitacora(nave);
       bitacora.consultarBitacora();

       Liquidable alferez = new Alferez("A01", "Alferez", 3, 0.005, "Tierra");
       Liquidable capitan = new Capitan("C01", "Capitan", 10, 0.2, "Vulcano");
       Liquidable teniente = new Teniente("T01", "Teniente", 5, 0.03, "Marte"); 
       Consejero consejero = new Consejero("CO01", "Consejero", 6, 0.05, "Marte");
       consejero.addCantidadConsejos(4); 

       
        Liquidable alferezMarciano = new Marciano(alferez);
        Liquidable capitanVulcano = new Vulcano(capitan);
        Liquidable tenienteTerricola = new Terricola(teniente);
        Liquidable consejeroTerricola = new Terricola(consejero);

        System.out.println("-> Alférez Marciano:\n   " + alferezMarciano.descripcionHaberes() + "\n   Total: $" + alferezMarciano.liquidacionDeHaberes());
        System.out.println("\n-> Capitán Vulcano:\n   " + capitanVulcano.descripcionHaberes() + "\n   Total: $" + capitanVulcano.liquidacionDeHaberes());
        System.out.println("\n-> Teniente Terrícola:\n   " + tenienteTerricola.descripcionHaberes() + "\n   Total: $" + tenienteTerricola.liquidacionDeHaberes());
        System.out.println("\n-> Consejero Terrícola:\n   " + consejeroTerricola.descripcionHaberes() + "\n   Total: $" + consejeroTerricola.liquidacionDeHaberes()); 

    }
}
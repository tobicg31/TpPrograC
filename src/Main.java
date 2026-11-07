import model.asistentes.Asistente;
import model.bitacoras.Bitacora;
import model.misiones.Mision;
import model.misiones.factory.MisionFactory;
import model.naves.Nave;
import model.naves.factory.NaveFactory;
import model.tripulantes.Alferez;
import model.tripulantes.Capitan;
import model.tripulantes.Consejero;
import model.tripulantes.Teniente;
import model.tripulantes.Tripulante;
import model.tripulantes.decorator.Liquidable;
import model.tripulantes.decorator.Marciano;
import model.tripulantes.decorator.Terricola;
import model.tripulantes.decorator.Vulcano;
//import model.concurrencia.*; // Importa todas las clases del paquete concurrencia

/**
 * Esta clase representa el punto de entrada principal del programa. Contiene el
 * método main que se encarga de ejecutar la lógica principal del sistema.
 */
public class Main {
    public static void main(String[] args) {


        //ACA IRA UNA PRIMER INTERFAZ DE USUARIO PARA ELEGIR LA NAVE Y EL TIPO DE MISION
        Nave nave = NaveFactory.getNave("Combate");
        Asistente asistente = new Asistente(nave);
        Bitacora bitacora = asistente.getBitacora();
        Sistema sistema = new Sistema();
        sistema.registrarAsistente(asistente);
        System.out.println("--- INICIO: Estado Inicial ---");

        System.out.println("Ciclo correcto del motor \nestado inicial:" + asistente.getEstadoMotor());
        asistente.prepararSalto();
        bitacora.consultarBitacora();
        asistente.saltar();
        bitacora.consultarBitacora();
        asistente.pasaTiempo();
        bitacora.consultarBitacora();
        
        System.out.println("\nCiclo incorrecto del motor\nestado inicial:" + nave.getMotor().getDescripcion());
        asistente.prepararSalto();
        bitacora.consultarBitacora();
        asistente.prepararSalto();
        bitacora.consultarBitacora();

        System.out.println("\nCreacion y ejecucion Mision 1");
        Mision m1 = MisionFactory.getMision("01");
        asistente.ejecutarMision(m1);
        bitacora.consultarBitacora();

        System.out.println("\nCreacion y ejecucion Mision 2");
        Mision m2 = MisionFactory.getMision("02");
        asistente.ejecutarMision(m2);
        bitacora.consultarBitacora();

        System.out.println("\nCreacion y ejecucion Mision 3");
        Mision m3 = MisionFactory.getMision("03");
        asistente.ejecutarMision(m3);
        bitacora.consultarBitacora();

        Tripulante alferez = new Alferez("A01", "Alferez", 3, 0.005, "Tierra");
        Tripulante capitan = new Capitan("C01", "Capitan", 10, 0.2, "Vulcano");
        Tripulante teniente = new Teniente("T01", "Teniente", 5, 0.03, "Marte");
        Consejero consejero = new Consejero("CO01", "Consejero", 6, 0.05, "Marte");
        consejero.addCantidadConsejos(4);

        System.out.println("\nCreacion de la tripulacion, minimo un capitan");
        Liquidable alferezMarciano = new Marciano(alferez);
        asistente.agregarTripulante(alferezMarciano);

        Liquidable capitanVulcano = new Vulcano(capitan);
        asistente.agregarTripulante(capitanVulcano);

        Liquidable tenienteTerricola = new Terricola(teniente);
        asistente.agregarTripulante(tenienteTerricola);
        
        Liquidable consejeroTerricola = new Terricola(consejero);
        asistente.agregarTripulante(consejeroTerricola);

        System.out.println("\nCalculo de sus respectivos haberes:");
        System.out.println("-> Alferez Marciano:\n   " + alferezMarciano.descripcionHaberes() + "\n");
        System.out.println("-> Capitan Vulcano:\n   " + capitanVulcano.descripcionHaberes() + "\n");
        System.out.println("-> Teniente Terricola:\n   " + tenienteTerricola.descripcionHaberes() + "\n");
        System.out.println("-> Consejero Terricola:\n   " + consejeroTerricola.descripcionHaberes() + "\n");


        //ACA IRA UNA SEGUNDA INTERFAZ DE USUARIO PARA EJECUTAR CONCURRENCIA DE RECURSO COMUN PLATADORMA DE CARGA
        //PODRIAMOS PEDIR Q ESPECIFIQUE CANT GENERADORES DE ENERGIA, CANT DE NAVES CONSUMIDORAS (NO IMPORTA EL TIPO DE NAVE)
    

    }
}
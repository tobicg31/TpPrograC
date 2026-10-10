import asistentes.Asistente;
import bitacoras.Bitacora;
import misiones.Mision;
import misiones.factory.MisionFactory;
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
    public static void main(String[] args) {
        Nave nave = NaveFactory.getNave("Combate");
        Asistente asistente = new Asistente(nave);
        Sistema sistema = new Sistema();
        sistema.registrarAsistente(asistente);
        System.out.println("--- INICIO: Estado Inicial ---");

        System.out.println("Ciclo correcto del motor \nestado inicial:" + nave.getMotor().getDescripcion());
        nave.getMotor().prepararSalto();
        System.out.println("estado: " + nave.getMotor().getDescripcion());
        nave.getMotor().saltar();
        System.out.println("estado: " + nave.getMotor().getDescripcion());
        nave.getMotor().pasaTiempo();
        System.out.println("estado: " + nave.getMotor().getDescripcion());

        System.out.println("\nCiclo incorrecto del motor\nestado inicial:" + nave.getMotor().getDescripcion());
        nave.getMotor().prepararSalto();
        System.out.println("estado: " + nave.getMotor().getDescripcion());
        nave.getMotor().pasaTiempo();
        System.out.println("estado: " + nave.getMotor().getDescripcion());

        System.out.println("\nCreacion y ejecucion Mision 1");
        Mision m1 = MisionFactory.getMision("01");
        asistente.ejecutarMision(m1);
        Bitacora bitacora = asistente.getBitacora();
        bitacora.consultarBitacora();

        System.out.println("\nCreacion y ejecucion Mision 2");
        Mision m2 = MisionFactory.getMision("02");
        asistente.ejecutarMision(m2);
        // Bitacora bitacora = asistente.getBitacora();
        bitacora.consultarBitacora();

        System.out.println("\nCreacion y ejecucion Mision 3");
        Mision m3 = MisionFactory.getMision("03");
        asistente.ejecutarMision(m3);
        // Bitacora bitacora = asistente.getBitacora();
        bitacora.consultarBitacora();

        Liquidable alferez = new Alferez("A01", "Alferez", 3, 0.005, "Tierra");
        Liquidable capitan = new Capitan("C01", "Capitan", 10, 0.2, "Vulcano");
        Liquidable teniente = new Teniente("T01", "Teniente", 5, 0.03, "Marte");
        Consejero consejero = new Consejero("CO01", "Consejero", 6, 0.05, "Marte");
        consejero.addCantidadConsejos(4);

        System.out.println("\nCreacion de la tripulacion, minimo un capitan");
        Liquidable alferezMarciano = new Marciano(alferez);
        Liquidable capitanVulcano = new Vulcano(capitan);
        Liquidable tenienteTerricola = new Terricola(teniente);
        Liquidable consejeroTerricola = new Terricola(consejero);

        System.out.println("\nCalculo de sus respectivos haberes:");
        System.out.println("-> Alferez Marciano:\n   " + alferezMarciano.descripcionHaberes() + "\n");
        System.out.println("\n-> Capitan Vulcano:\n   " + capitanVulcano.descripcionHaberes() + "\n");
        System.out.println("\n-> Teniente Terricola:\n   " + tenienteTerricola.descripcionHaberes() + "\n");
        System.out.println("\n-> Consejero Terricola:\n   " + consejeroTerricola.descripcionHaberes() + "\n");

    }
}
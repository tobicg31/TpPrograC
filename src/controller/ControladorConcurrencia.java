
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import model.concurrencia.GeneradoradeEnergia;
import model.concurrencia.NaveConsumidora;
import model.concurrencia.PlataformaDeCarga;
import view.IVentanaConcurrencia;
import view.IVentanaMenu;

public class ControladorConcurrencia implements ActionListener {
    private final IVentanaConcurrencia vista;
    private final IVentanaMenu vistaMenu;
    private final PlataformaDeCarga modelo;
    private int cantNaves = 0;
    private int cantGeneradores = 0;

    public ControladorConcurrencia(IVentanaConcurrencia vista, IVentanaMenu vistaMenu, PlataformaDeCarga modelo) {
        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.modelo = modelo;
        this.vista.setActionListener(this);
        this.modelo.agregarObservador(vista); // la vista se suscribe a la plataforma
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CREAR NAVE":
                cantNaves++;
                vista.agregarNave("Nave " + cantNaves);
                break;
            case "CREAR GENERADOR":
                cantGeneradores++;
                vista.agregarGenerador("Generadora " + cantGeneradores);
                break;
            case "EJECUTAR":
                if (vista.validaParametros()) {
                    ejecutar();
                }
                break;
            case "VOLVER":
                vista.cierra();
                vistaMenu.arranca(null);
                break;
            default:
                break;
        }
    }

    private void ejecutar() {
        ArrayList<Thread> hilos = new ArrayList<>();
        for (int i = 1; i <= cantGeneradores; i++) {
            Thread hiloGenerador = new Thread(new GeneradoradeEnergia(i, modelo));
            hilos.add(hiloGenerador);
        }
        for (int i = 1; i <= cantNaves; i++) {
            Thread hiloNave = new Thread(new NaveConsumidora(i, modelo));
            hilos.add(hiloNave);
        }
        Collections.shuffle(hilos);
        for (Thread hilo : hilos) {
        hilo.start();
        }
    }
}
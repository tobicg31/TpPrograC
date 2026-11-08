
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.concurrencia.GeneradoradeEnergia;
import model.concurrencia.NaveConsumidora;
import model.concurrencia.PlataformaDeCarga;
import view.IVentanaConcurrencia;

public class ControladorConcurrencia implements ActionListener {
    private final IVentanaConcurrencia vista;
    private final PlataformaDeCarga modelo;
    private int cantNaves = 0;
    private int cantGeneradores = 0;

    public ControladorConcurrencia(IVentanaConcurrencia vista, PlataformaDeCarga modelo) {
        this.vista = vista;
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
            default:
                break;
        }
    }

    private void ejecutar() {
        for (int i = 1; i <= cantGeneradores; i++) {
            new Thread(new GeneradoradeEnergia(i, modelo, 1)).start();
        }
        for (int i = 1; i <= cantNaves; i++) {
            new Thread(new NaveConsumidora(i, modelo)).start();
        }
    }
}
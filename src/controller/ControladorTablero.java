package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import model.asistentes.Asistente;
import model.bitacoras.EventoBitacora;
import model.destinoytablero.CantidadDeElementosSuperaCasillaException;
import model.destinoytablero.Destino;
import model.destinoytablero.DimensionesDeTableroInconsistentesException;
import model.destinoytablero.Tablero;
import model.elementosUniverso.Ayuda;
import model.elementosUniverso.ElementoDelUniverso;
import model.elementosUniverso.Obstaculo;
import model.misiones.Mision;
import model.misiones.factory.MisionFactory;
import model.naves.Nave;
import model.naves.factory.NaveFactory;
import view.IVentanaConfiguracionTablero;
import view.IVentanaMenu;
import view.IVentanaTablero;

public class ControladorTablero implements ActionListener {
    private static final String[] TIPOS_NAVE_ENEMIGA = { "Carguero", "Combate", "Exploradora" };
    private final IVentanaConfiguracionTablero vistaConfiguracion;
    private final IVentanaTablero vista;
    private final IVentanaMenu vistaMenu;
    private final Supplier<Nave> proveedorNave;
    private final Random azar = new Random();
    private Tablero tablero;
    private Destino destino;
    private Asistente asistente;

    public ControladorTablero(IVentanaConfiguracionTablero vistaConfiguracion,
            IVentanaTablero vista, IVentanaMenu vistaMenu, Supplier<Nave> proveedorNave) {
        this.vistaConfiguracion = vistaConfiguracion;
        this.vista = vista;
        this.vistaMenu = vistaMenu;
        this.proveedorNave = proveedorNave;
        this.vistaConfiguracion.setActionListener(this);
        this.vista.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        switch (evento.getActionCommand()) {
            case IVentanaConfiguracionTablero.CREAR_TABLERO:
                crearTablero();
                break;
            case IVentanaConfiguracionTablero.VOLVER:
                this.vistaConfiguracion.cierra();
                this.vistaMenu.arranca(null);
                break;
            case IVentanaTablero.INICIAR_MISION:
                iniciarMision();
                break;
            case IVentanaTablero.VOLVER:
                cerrarControl();
                break;
            default:
                break;
        }
    }

    private void crearTablero() {
        int ancho = this.vistaConfiguracion.getAncho();
        int alto = this.vistaConfiguracion.getAlto();
        int obstaculos = this.vistaConfiguracion.getCantidadObstaculos();
        int navesEnemigas = this.vistaConfiguracion.getCantidadNavesEnemigas();
        int ayudas = this.vistaConfiguracion.getCantidadAyudas();
        long cantidadElementos = (long) obstaculos + navesEnemigas + ayudas;
        long limiteElementos = ((long) ancho * alto / 4) * 3;
        if (cantidadElementos > limiteElementos) {
            this.vistaConfiguracion.mostrarError(
                    "La cantidad total de elementos supera el límite del tablero (" + limiteElementos + ").");
            return;
        }

        ArrayList<ElementoDelUniverso> elementos = new ArrayList<ElementoDelUniverso>();
        for (int i = 0; i < obstaculos; i++) {
            elementos.add(new Obstaculo(8));
        }
        for (int i = 0; i < navesEnemigas; i++) {
            String tipoEnemigo = TIPOS_NAVE_ENEMIGA[this.azar.nextInt(TIPOS_NAVE_ENEMIGA.length)];
            elementos.add(NaveFactory.getNave(tipoEnemigo));
        }
        for (int i = 0; i < ayudas; i++) {
            elementos.add(new Ayuda(12, 12));
        }

        try {
            this.tablero = new Tablero(alto, ancho, elementos);
            this.destino = new Destino(this.tablero);
            this.vista.observarTablero(this.tablero);
            Nave nave = this.proveedorNave.get();
            if (nave == null) {
                nave = NaveFactory.getNave("Exploradora");
            }
            this.asistente = new Asistente(nave, this.tablero);
            this.asistente.getBitacora().agregarEntrada(
                    "Tablero creado: " + ancho + " x " + alto + " (ancho x alto)", "INFO");
            actualizarVista();
            this.vistaConfiguracion.cierra();
            this.vista.arranca();
        } catch (DimensionesDeTableroInconsistentesException | CantidadDeElementosSuperaCasillaException e) {
            this.vistaConfiguracion.mostrarError(e.getMessage());
        }
    }

    private void iniciarMision() {
        if (this.tablero == null || this.asistente == null) {
            this.vista.mostrarError("Primero debe crear un tablero.");
            return;
        }

        String idMision = this.vista.getMision();
        Mision mision = MisionFactory.getMision(idMision, this.tablero, this.destino);
        if (mision == null) {
            this.vista.mostrarError("La misión seleccionada no es válida.");
            return;
        }
        this.vista.limpiarError();
        this.asistente.getBitacora().agregarEntrada("Inicio de misión " + mision.getNombreMision(), "INFO");
        this.vista.setMisionActiva(true);
        try {
            this.asistente.ejecutarMision(mision);
        } finally {
            this.vista.setMisionActiva(false);
            actualizarVista();
        }
    }

    private void actualizarVista() {
        Nave nave = this.asistente.getNave();
        this.vista.mostrarRecursos(nave.getClass().getSimpleName(), nave.getCombustible(), nave.getEnergia(),
                nave.getDesgaste(), this.asistente.getEstadoMotor());
        ArrayList<EventoBitacora> eventos = new ArrayList<EventoBitacora>(
                this.asistente.getBitacora().getEntradas());
        this.vista.mostrarEventos(eventos);
        ArrayList<EventoBitacora> informes = new ArrayList<EventoBitacora>();
        for (EventoBitacora evento : eventos) {
            if ("INFORME".equals(evento.getTipo())) {
                informes.add(evento);
            }
        }
        this.vista.mostrarInformes(informes);
    }

    private void cerrarControl() {
        this.vista.cierra();
        this.vistaMenu.arranca(null);
    }
}

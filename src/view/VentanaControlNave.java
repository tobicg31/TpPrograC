package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

import model.asistentes.Asistente;
import model.bitacoras.EventoBitacora;
import model.destinoytablero.Posicion;
import model.destinoytablero.Tablero;
import model.elementosUniverso.Ayuda;
import model.elementosUniverso.ElementoDelUniverso;
import model.elementosUniverso.Obstaculo;
import model.naves.Nave;

public class VentanaControlNave extends JFrame implements IVentanaTablero {
    private static final long serialVersionUID = 1L;
    private final JLabel lblNave;
    private final JLabel lblCombustible;
    private final JLabel lblEnergia;
    private final JLabel lblDesgaste;
    private final JLabel lblMotor;
    private final JLabel lblEstadoMision;
    private final JComboBox<String> cmbMision;
    private final JButton btnIniciar;
    private final JButton btnVolver;
    private final JTable tablaTablero;
    private final JTextArea txtInformes;
    private final JTextArea txtBitacora;
    private final JSplitPane distribucionSuperior;
    private Tablero tableroObservado;
    private Asistente asistenteObservado;
    private int filasTablero = -1;
    private int columnasTablero = -1;

    public VentanaControlNave() {
        setTitle("Control de la Nave");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 850);
        setMinimumSize(new java.awt.Dimension(900, 650));

        JPanel principal = new JPanel(new GridBagLayout());
        principal.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(principal);

        JPanel superior = new JPanel(new BorderLayout());

        JPanel recursos = new JPanel(new GridBagLayout());
        recursos.setBorder(BorderFactory.createTitledBorder("Estado actual de la nave"));
        this.lblNave = new JLabel("Nave: -");
        this.lblCombustible = new JLabel("Combustible: -");
        this.lblEnergia = new JLabel("Energía: -");
        this.lblDesgaste = new JLabel("Desgaste: -");
        this.lblMotor = new JLabel("Motor: -");
        this.lblEstadoMision = new JLabel("Sin misión en curso");
        this.cmbMision = new JComboBox<String>(new String[] {
                "01 - Intercepción / asistencia", "02 - Recolección", "03 - Retorno seguro"
        });
        this.cmbMision.setPrototypeDisplayValue("01 - Intercepción / asistencia");
        this.btnIniciar = new JButton("Iniciar misión");
        this.btnIniciar.setActionCommand(INICIAR_MISION);
        GridBagConstraints recurso = new GridBagConstraints();
        recurso.gridx = 0;
        recurso.gridy = GridBagConstraints.RELATIVE;
        recurso.anchor = GridBagConstraints.WEST;
        recurso.fill = GridBagConstraints.HORIZONTAL;
        recurso.weightx = 1;
        recurso.insets = new Insets(3, 8, 3, 8);
        recursos.add(this.lblNave, recurso);
        recursos.add(this.lblCombustible, recurso);
        recursos.add(this.lblEnergia, recurso);
        recursos.add(this.lblDesgaste, recurso);
        recursos.add(this.lblMotor, recurso);
        recursos.add(this.cmbMision, recurso);
        recursos.add(this.btnIniciar, recurso);
        recursos.add(this.lblEstadoMision, recurso);
        JPanel informes = new JPanel(new BorderLayout(0, 6));
        informes.setBorder(BorderFactory.createTitledBorder("Historial de informes finales"));
        this.txtInformes = crearAreaTexto();
        informes.add(new JScrollPane(this.txtInformes), BorderLayout.CENTER);

        JPanel mapa = new JPanel(new BorderLayout(0, 6));
        mapa.setBorder(BorderFactory.createTitledBorder("Tablero en tiempo real"));
        JLabel leyenda = new JLabel("N: nave   O: obstáculo   E: enemiga   A: ayuda   X: destino",
                SwingConstants.CENTER);
        mapa.add(leyenda, BorderLayout.NORTH);
        this.tablaTablero = new JTable(new DefaultTableModel());
        this.tablaTablero.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tablaTablero.setRowHeight(26);
        this.tablaTablero.setCellSelectionEnabled(false);
        this.tablaTablero.setRowSelectionAllowed(false);
        mapa.add(new JScrollPane(this.tablaTablero), BorderLayout.CENTER);

        JPanel panelIzquierdo = new JPanel(new GridLayout(2, 1, 0, 8));
        panelIzquierdo.add(recursos);
        panelIzquierdo.add(informes);
        this.distribucionSuperior = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, mapa);
        this.distribucionSuperior.setBorder(null);
        this.distribucionSuperior.setResizeWeight(0.35);
        this.distribucionSuperior.setContinuousLayout(true);
        superior.add(this.distribucionSuperior, BorderLayout.CENTER);

        GridBagConstraints seccion = new GridBagConstraints();
        seccion.gridx = 0;
        seccion.gridy = 0;
        seccion.gridwidth = 1;
        seccion.fill = GridBagConstraints.BOTH;
        seccion.weightx = 1;
        seccion.weighty = 2;
        seccion.insets = new Insets(0, 0, 4, 0);
        principal.add(superior, seccion);

        JPanel bitacora = new JPanel(new BorderLayout(0, 6));
        bitacora.setBorder(BorderFactory.createTitledBorder("Bitácora de eventos"));
        this.txtBitacora = crearAreaTexto();
        bitacora.add(new JScrollPane(this.txtBitacora), BorderLayout.CENTER);
        JPanel acciones = new JPanel(new BorderLayout());
        this.btnVolver = new JButton("Volver al menú");
        this.btnVolver.setActionCommand(VOLVER);
        acciones.add(this.btnVolver, BorderLayout.WEST);
        bitacora.add(acciones, BorderLayout.SOUTH);
        seccion.gridy = 1;
        seccion.weighty = 1;
        seccion.insets = new Insets(4, 0, 0, 0);
        principal.add(bitacora, seccion);

        TemaOscuro.aplicar(this);
    }

    private JTextArea crearAreaTexto() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("Dialog", Font.PLAIN, 13));
        return area;
    }

    @Override
    public void setActionListener(ActionListener listener) {
        this.btnIniciar.addActionListener(listener);
        this.btnVolver.addActionListener(listener);
    }

    @Override
    public int getFilasTablero() {
        return this.filasTablero;
    }

    @Override
    public int getColumnasTablero() {
        return this.columnasTablero;
    }

    @Override
    public String getMision() {
        switch (this.cmbMision.getSelectedIndex()) {
            case 0:
                return Mision01;
            case 1:
                return Mision02;
            default:
                return Mision03;
        }
    }

    private void mostrarTablero(ElementoDelUniverso[][] elementos, Posicion nave, Posicion objetivo) {
        int filas = elementos.length;
        int columnas = filas == 0 ? 0 : elementos[0].length;
        if (filas != this.filasTablero || columnas != this.columnasTablero) {
            Object[] nombresColumnas = new Object[columnas];
            for (int columna = 0; columna < columnas; columna++) {
                nombresColumnas[columna] = Integer.valueOf(columna);
            }
            Object[][] celdas = new Object[filas][columnas];
            this.tablaTablero.setModel(new DefaultTableModel(celdas, nombresColumnas) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            });
            this.filasTablero = filas;
            this.columnasTablero = columnas;
            for (int columna = 0; columna < columnas; columna++) {
                this.tablaTablero.getColumnModel().getColumn(columna).setMinWidth(42);
                this.tablaTablero.getColumnModel().getColumn(columna).setMaxWidth(42);
                this.tablaTablero.getColumnModel().getColumn(columna).setPreferredWidth(42);
                this.tablaTablero.getColumnModel().getColumn(columna).setWidth(42);
            }
        }

        DefaultTableModel modelo = (DefaultTableModel) this.tablaTablero.getModel();
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                String simbolo = simbolo(elementos[fila][columna]);
                Posicion posicion = new Posicion(fila, columna);
                if (posicion.equals(objetivo)) {
                    simbolo = "X";
                }
                if (posicion.equals(nave)) {
                    simbolo = "N";
                }
                modelo.setValueAt(simbolo, fila, columna);
            }
        }
    }

    @Override
    public void observarTablero(Tablero tablero) {
        if (this.tableroObservado != null) {
            this.tableroObservado.quitarObservador(this);
        }
        this.tableroObservado = tablero;
        if (this.tableroObservado != null) {
            this.tableroObservado.agregarObservador(this);
            actualizar();
        }
    }

    @Override
    public void observarAsistente(Asistente asistente) {
        this.asistenteObservado = asistente;
        actualizar();
    }

    @Override
    public void actualizar() {
        Runnable actualizarVistaCompleta = () -> {
            if (this.tableroObservado != null) {
                mostrarTablero(this.tableroObservado.verTablero(),
                        this.tableroObservado.getPosicionNave(),
                        this.tableroObservado.getObjetivo());
            }
            if (this.asistenteObservado != null) {
                Nave nave = this.asistenteObservado.getNave();
                mostrarRecursos(nave.getClass().getSimpleName(), nave.getCombustible(), nave.getEnergia(),
                        nave.getDesgaste(), this.asistenteObservado.getEstadoMotor());
                List<EventoBitacora> eventos = new java.util.ArrayList<>(
                        this.asistenteObservado.getBitacora().getEntradas());
                mostrarEventos(eventos);
                List<EventoBitacora> informes = new java.util.ArrayList<>();
                for (EventoBitacora evento : eventos) {
                    if ("INFORME".equals(evento.getTipo())) {
                        informes.add(evento);
                    }
                }
                mostrarInformes(informes);
            }
        };
        if (SwingUtilities.isEventDispatchThread()) {
            actualizarVistaCompleta.run();
        } else {
            SwingUtilities.invokeLater(actualizarVistaCompleta);
        }
    }

    private String simbolo(ElementoDelUniverso elemento) {
        if (elemento instanceof Obstaculo) {
            return "O";
        }
        if (elemento instanceof Nave) {
            return "E";
        }
        if (elemento instanceof Ayuda) {
            return "A";
        }
        return "";
    }

    @Override
    public void mostrarRecursos(String tipoNave, int combustible, int energia, int desgaste, String estadoMotor) {
        this.lblNave.setText("Nave: " + tipoNave);
        this.lblCombustible.setText("Combustible: " + combustible);
        this.lblEnergia.setText("Energía: " + energia);
        this.lblDesgaste.setText("Desgaste: " + desgaste + "%");
        this.lblMotor.setText("Motor: " + estadoMotor);
    }

    @Override
    public void mostrarEventos(List<EventoBitacora> eventos) {
        this.txtBitacora.setText(formatearEventos(eventos));
        this.txtBitacora.setCaretPosition(this.txtBitacora.getDocument().getLength());
    }

    @Override
    public void mostrarInformes(List<EventoBitacora> informes) {
        this.txtInformes.setText(formatearEventos(informes));
        this.txtInformes.setCaretPosition(this.txtInformes.getDocument().getLength());
    }

    private String formatearEventos(List<EventoBitacora> eventos) {
        StringBuilder texto = new StringBuilder();
        for (EventoBitacora evento : eventos) {
            texto.append(evento.getFecha()).append(" - ").append(evento.getTipo()).append(": ")
                    .append(evento.getMensaje()).append(System.lineSeparator());
        }
        return texto.toString();
    }

    @Override
    public void setMisionActiva(boolean activa) {
        this.btnIniciar.setEnabled(!activa);
        this.cmbMision.setEnabled(!activa);
        this.lblEstadoMision.setText(activa ? "Misión en curso..." : "Sin misión en curso");
    }

    public void setEstadoMision(String estado) {
        this.lblEstadoMision.setText(estado);
    }

    @Override
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(this, error, "Control de la nave", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void limpiarError() {
        // Los errores se presentan en diálogos modales y no quedan en la vista.
    }

    @Override
    public void arranca() {
        setLocationRelativeTo(null);
        setVisible(true);
        this.distribucionSuperior.setDividerLocation(0.35);
    }

    @Override
    public void cierra() {
        observarTablero(null);
        this.asistenteObservado = null;
        dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new VentanaControlNave().arranca());
    }
}

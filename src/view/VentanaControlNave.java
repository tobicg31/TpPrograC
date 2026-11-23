package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
    private final JButton btnVolverAJugar;
    private final JCheckBox chkSonido;
    private final JTable tablaTablero;
    private final JTextArea txtInformes;
    private final JTextArea txtBitacora;
    private final JSplitPane distribucionSuperior;
    private final JSplitPane distribucionVertical;
    private Tablero tableroObservado;
    private Asistente asistenteObservado;
    private int filasTablero = -1;
    private int columnasTablero = -1;
    private int eventosProcesadosSonido = 0;
    private Posicion ultimaPosicionNave = null;

    public VentanaControlNave() {
        setTitle("Control de la Nave");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 850);
        setMinimumSize(new java.awt.Dimension(900, 650));

        JPanel principal = new JPanel(new BorderLayout());
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
        this.txtInformes = crearAreaTexto(6);
        JScrollPane scrollInformes = new JScrollPane(this.txtInformes);
        scrollInformes.setPreferredSize(new java.awt.Dimension(200, 150));
        scrollInformes.setMinimumSize(new java.awt.Dimension(150, 80));
        informes.add(scrollInformes, BorderLayout.CENTER);

        JPanel mapa = new JPanel(new BorderLayout(0, 6));
        mapa.setBorder(BorderFactory.createTitledBorder("Tablero en tiempo real"));
        this.tablaTablero = new JTable(new DefaultTableModel());
        this.tablaTablero.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tablaTablero.setRowHeight(32);
        this.tablaTablero.setCellSelectionEnabled(false);
        this.tablaTablero.setRowSelectionAllowed(false);
        this.tablaTablero.setShowGrid(true);
        this.tablaTablero.setGridColor(new Color(45, 50, 56));
        this.tablaTablero.setDefaultRenderer(Object.class, new TableroCeldaRenderer());
        mapa.add(new JScrollPane(this.tablaTablero), BorderLayout.CENTER);

        JPanel panelIzquierdo = new JPanel(new GridLayout(2, 1, 0, 8));
        panelIzquierdo.add(recursos);
        panelIzquierdo.add(informes);
        this.distribucionSuperior = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, mapa);
        this.distribucionSuperior.setBorder(null);
        this.distribucionSuperior.setResizeWeight(0.35);
        this.distribucionSuperior.setContinuousLayout(true);
        superior.add(this.distribucionSuperior, BorderLayout.CENTER);
        superior.setMinimumSize(new java.awt.Dimension(400, 320));

        JPanel bitacora = new JPanel(new BorderLayout(0, 6));
        bitacora.setBorder(BorderFactory.createTitledBorder("Bitácora de eventos"));
        this.txtBitacora = crearAreaTexto(8);
        JScrollPane scrollBitacora = new JScrollPane(this.txtBitacora);
        scrollBitacora.setPreferredSize(new java.awt.Dimension(300, 180));
        scrollBitacora.setMinimumSize(new java.awt.Dimension(200, 100));
        bitacora.add(scrollBitacora, BorderLayout.CENTER);
        JPanel acciones = new JPanel(new BorderLayout(8, 0));
        this.btnVolver = new JButton("Volver al menú");
        this.btnVolver.setActionCommand(VOLVER);
        this.btnVolverAJugar = new JButton("Volver a jugar");
        this.btnVolverAJugar.setActionCommand(REINICIAR);
        this.chkSonido = new JCheckBox("Sonido espacial", true);
        this.chkSonido.setOpaque(false);
        this.chkSonido.setForeground(Color.WHITE);
        this.chkSonido.setFont(new Font("Dialog", Font.BOLD, 13));
        this.chkSonido.setFocusPainted(false);
        this.chkSonido.addActionListener(e -> ReproductorSonido.setHabilitado(this.chkSonido.isSelected()));
        JPanel panelCentroSonido = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));
        panelCentroSonido.setOpaque(false);
        panelCentroSonido.add(this.chkSonido);
        acciones.add(this.btnVolver, BorderLayout.WEST);
        acciones.add(panelCentroSonido, BorderLayout.CENTER);
        acciones.add(this.btnVolverAJugar, BorderLayout.EAST);
        bitacora.add(acciones, BorderLayout.SOUTH);
        bitacora.setMinimumSize(new java.awt.Dimension(400, 140));

        this.distribucionVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, superior, bitacora);
        this.distribucionVertical.setBorder(null);
        this.distribucionVertical.setResizeWeight(0.65);
        this.distribucionVertical.setContinuousLayout(true);
        principal.add(this.distribucionVertical, BorderLayout.CENTER);

        TemaOscuro.aplicar(this);
    }


    private JTextArea crearAreaTexto(int filas) {
        JTextArea area = new JTextArea(filas, 20);
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
        this.btnVolverAJugar.addActionListener(listener);
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
                this.tablaTablero.getColumnModel().getColumn(columna).setMinWidth(32);
                this.tablaTablero.getColumnModel().getColumn(columna).setMaxWidth(32);
                this.tablaTablero.getColumnModel().getColumn(columna).setPreferredWidth(32);
                this.tablaTablero.getColumnModel().getColumn(columna).setWidth(32);
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
                Posicion posicionActual = this.tableroObservado.getPosicionNave();
                if (this.ultimaPosicionNave != null && posicionActual != null && !posicionActual.equals(this.ultimaPosicionNave)) {
                    int distancia = Math.abs(posicionActual.getX() - this.ultimaPosicionNave.getX())
                            + Math.abs(posicionActual.getY() - this.ultimaPosicionNave.getY());
                    if (distancia == 1) {
                        ReproductorSonido.saltoComun();
                    }
                }
                this.ultimaPosicionNave = posicionActual;
                mostrarTablero(this.tableroObservado.verTablero(),
                        posicionActual,
                        this.tableroObservado.getObjetivo());
            }
            if (this.asistenteObservado != null) {
                Nave nave = this.asistenteObservado.getNave();
                mostrarRecursos(nave.getClass().getSimpleName(), nave.getCombustible(), nave.getEnergia(),
                        nave.getDesgaste(), this.asistenteObservado.getEstadoMotor());
                List<EventoBitacora> eventos = new java.util.ArrayList<>(
                        this.asistenteObservado.getBitacora().getEntradas());
                if (eventos.size() > this.eventosProcesadosSonido) {
                    for (int i = this.eventosProcesadosSonido; i < eventos.size(); i++) {
                        EventoBitacora ev = eventos.get(i);
                        String tipo = ev.getTipo();
                        String msj = ev.getMensaje().toLowerCase();
                        if ("ENCUENTRO".equalsIgnoreCase(tipo) || msj.contains("choca") || msj.contains("obstáculo") || msj.contains("inoperativa")) {
                            ReproductorSonido.colision();
                        } else if (msj.contains("en warp a: enfriamento") || (msj.contains("warp") && msj.contains("enfriam"))) {
                            ReproductorSonido.warp();
                        }
                    }
                    this.eventosProcesadosSonido = eventos.size();
                }
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
        this.btnVolverAJugar.setEnabled(!activa);
        this.cmbMision.setEnabled(!activa);
        this.lblEstadoMision.setText(activa ? "Misión en curso..." : "Sin misión en curso");
    }

    @Override
    public void limpiarPartida() {
        this.eventosProcesadosSonido = 0;
        this.ultimaPosicionNave = null;
        this.txtBitacora.setText("");
        this.txtInformes.setText("");
        this.lblEstadoMision.setText("Sin misión en curso");
        this.btnIniciar.setEnabled(true);
        this.btnVolverAJugar.setEnabled(true);
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
        this.distribucionVertical.setDividerLocation(0.65);
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

    private static class TableroCeldaRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;
        private final Map<String, Icon> iconos = new HashMap<>();

        // Colores temáticos espaciales provisorios
        private static final Color COLOR_ESPACIO = new Color(24, 27, 31);
        private static final Color COLOR_NAVE = new Color(28, 120, 205); // Azul cian brillante
        private static final Color COLOR_OBSTACULO = new Color(105, 95, 90); // Gris roca
        private static final Color COLOR_ENEMIGA = new Color(190, 45, 45); // Rojo combate
        private static final Color COLOR_AYUDA = new Color(42, 155, 85); // Verde recarga
        private static final Color COLOR_DESTINO = new Color(195, 135, 25); // Dorado objetivo
        private static final Color COLOR_BORDE_CELDA = new Color(45, 50, 56);

        public TableroCeldaRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setFont(new Font("Dialog", Font.BOLD, 12));
            cargarIconos();
        }

        private void cargarIconos() {
            cargarIcono("N", "/imagenes/nave.png", "/nave.png");
            cargarIcono("O", "/imagenes/obstaculo.png", "/imagenes/asteroide.png", "/obstaculo.png", "/asteroide.png");
            cargarIcono("E", "/imagenes/enemigo.png", "/imagenes/nave_enemiga.png", "/enemigo.png",
                    "/nave_enemiga.png");
            cargarIcono("A", "/imagenes/ayuda.png", "/imagenes/estacion.png", "/ayuda.png", "/estacion.png");
            cargarIcono("X", "/imagenes/destino.png", "/imagenes/base.png", "/destino.png", "/base.png");
        }

        private void cargarIcono(String clave, String... rutas) {
            for (String ruta : rutas) {
                java.net.URL url = getClass().getResource(ruta);
                if (url != null) {
                    ImageIcon original = new ImageIcon(url);
                    Image escalada = original.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
                    this.iconos.put(clave, new ImageIcon(escalada));
                    return;
                }
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setOpaque(true);
            setBorder(BorderFactory.createLineBorder(COLOR_BORDE_CELDA, 1));

            String texto = value != null ? value.toString() : "";
            Icon icono = this.iconos.get(texto);

            if (icono != null) {
                setIcon(icono);
                setText("");
                setBackground(COLOR_ESPACIO);
                setForeground(Color.WHITE);
                switch (texto) {
                    case "N":
                        setToolTipText("Nave propia");
                        break;
                    case "O":
                        setToolTipText("Obstáculo / Asteroide");
                        break;
                    case "E":
                        setToolTipText("Nave enemiga");
                        break;
                    case "A":
                        setToolTipText("Estación de recarga / Ayuda");
                        break;
                    case "X":
                        setToolTipText("Destino de la misión");
                        break;
                    default:
                        setToolTipText(null);
                        break;
                }
            } else {
                setIcon(null);
                switch (texto) {
                    case "N":
                        setBackground(COLOR_NAVE);
                        setForeground(Color.WHITE);
                        setText("N");
                        setToolTipText("Nave propia");
                        break;
                    case "O":
                        setBackground(COLOR_OBSTACULO);
                        setForeground(Color.WHITE);
                        setText("O");
                        setToolTipText("Obstáculo / Asteroide");
                        break;
                    case "E":
                        setBackground(COLOR_ENEMIGA);
                        setForeground(Color.WHITE);
                        setText("E");
                        setToolTipText("Nave enemiga");
                        break;
                    case "A":
                        setBackground(COLOR_AYUDA);
                        setForeground(Color.WHITE);
                        setText("A");
                        setToolTipText("Estación de recarga / Ayuda");
                        break;
                    case "X":
                        setBackground(COLOR_DESTINO);
                        setForeground(Color.WHITE);
                        setText("X");
                        setToolTipText("Destino de la misión");
                        break;
                    default:
                        setBackground(COLOR_ESPACIO);
                        setForeground(Color.GRAY);
                        setText("");
                        setToolTipText(null);
                        break;
                }
            }
            return this;
        }
    }
}

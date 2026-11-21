package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class VentanaConfiguracionTablero extends JFrame implements IVentanaConfiguracionTablero {
    private static final long serialVersionUID = 1L;
    private final JSpinner spnAncho;
    private final JSpinner spnAlto;
    private final JSpinner spnObstaculos;
    private final JSpinner spnNavesEnemigas;
    private final JSpinner spnAyudas;
    private final JButton btnCrear;
    private final JButton btnVolver;

    public VentanaConfiguracionTablero() {
        setTitle("Configuración del Tablero");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(620, 520);
        setMinimumSize(getSize());

        JPanel principal = new JPanel(new BorderLayout(0, 14));
        principal.setBorder(new EmptyBorder(18, 22, 18, 22));
        setContentPane(principal);

        JPanel cabecera = new JPanel(new BorderLayout(0, 6));
        cabecera.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(125, 130, 135)),
                new EmptyBorder(14, 12, 14, 12)));
        JLabel titulo = new JLabel("Configuración del universo", SwingConstants.CENTER);
        titulo.setFont(new Font("Dialog", Font.BOLD, 24));
        cabecera.add(titulo, BorderLayout.CENTER);
        JLabel descripcion = new JLabel("Definí las dimensiones y los elementos del tablero",
                SwingConstants.CENTER);
        cabecera.add(descripcion, BorderLayout.SOUTH);
        principal.add(cabecera, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createTitledBorder("Parámetros del tablero"));
        GridBagConstraints etiqueta = new GridBagConstraints();
        etiqueta.gridx = 0;
        etiqueta.anchor = GridBagConstraints.WEST;
        etiqueta.insets = new Insets(9, 12, 9, 12);
        GridBagConstraints campo = new GridBagConstraints();
        campo.gridx = 1;
        campo.fill = GridBagConstraints.HORIZONTAL;
        campo.weightx = 1;
        campo.insets = new Insets(9, 12, 9, 12);

        this.spnAncho = new JSpinner(new SpinnerNumberModel(15, 5, 100, 1));
        this.spnAlto = new JSpinner(new SpinnerNumberModel(10, 5, 100, 1));
        this.spnObstaculos = new JSpinner(new SpinnerNumberModel(12, 0, 10000, 1));
        this.spnNavesEnemigas = new JSpinner(new SpinnerNumberModel(4, 0, 10000, 1));
        this.spnAyudas = new JSpinner(new SpinnerNumberModel(5, 0, 10000, 1));

        agregarCampo(formulario, etiqueta, campo, 0, "X - Ancho del tablero (5 a 100):", this.spnAncho);
        agregarCampo(formulario, etiqueta, campo, 1, "Y - Alto del tablero (5 a 100):", this.spnAlto);
        agregarCampo(formulario, etiqueta, campo, 2, "Cantidad de obstáculos:", this.spnObstaculos);
        agregarCampo(formulario, etiqueta, campo, 3, "Cantidad de naves enemigas:", this.spnNavesEnemigas);
        agregarCampo(formulario, etiqueta, campo, 4, "Cantidad de ayudas:", this.spnAyudas);
        principal.add(formulario, BorderLayout.CENTER);

        JPanel acciones = new JPanel(new BorderLayout());
        this.btnVolver = new JButton("Volver");
        this.btnVolver.setActionCommand(VOLVER);
        acciones.add(this.btnVolver, BorderLayout.WEST);
        this.btnCrear = new JButton("Crear tablero");
        this.btnCrear.setActionCommand(CREAR_TABLERO);
        acciones.add(this.btnCrear, BorderLayout.EAST);
        principal.add(acciones, BorderLayout.SOUTH);

        TemaOscuro.aplicar(this);
    }

    private void agregarCampo(JPanel panel, GridBagConstraints etiqueta, GridBagConstraints campo,
            int fila, String texto, JSpinner spinner) {
        etiqueta.gridy = fila;
        campo.gridy = fila;
        panel.add(new JLabel(texto), etiqueta);
        panel.add(spinner, campo);
    }

    @Override
    public void setActionListener(ActionListener listener) {
        this.btnCrear.addActionListener(listener);
        this.btnVolver.addActionListener(listener);
    }

    @Override
    public int getAncho() {
        return ((Integer) this.spnAncho.getValue()).intValue();
    }

    @Override
    public int getAlto() {
        return ((Integer) this.spnAlto.getValue()).intValue();
    }

    @Override
    public int getCantidadObstaculos() {
        return ((Integer) this.spnObstaculos.getValue()).intValue();
    }

    @Override
    public int getCantidadNavesEnemigas() {
        return ((Integer) this.spnNavesEnemigas.getValue()).intValue();
    }

    @Override
    public int getCantidadAyudas() {
        return ((Integer) this.spnAyudas.getValue()).intValue();
    }

    @Override
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void arranca() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void cierra() {
        dispose();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new VentanaConfiguracionTablero().arranca());
    }
}

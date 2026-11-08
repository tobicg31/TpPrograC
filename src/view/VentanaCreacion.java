package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaCreacion extends JFrame implements IVentanaCreacion {

	private static final long serialVersionUID = 1L;
	public static final String ACCION_INSTANCIAR = "ACCION_INSTANCIAR";
	public static final String ACCION_AGREGAR = "ACCION_AGREGAR";

	private JPanel panelPrincipal;
	private JPanel panelContenedor;
	private JPanel panelCreacion;
	private JPanel panelInstanciarNave;
	private JPanel panelCrearTripulante;
	private JPanel panelTripulantes;
	private JPanel panelResumen;
	private JComboBox<String> cmbTipoNave;
	private JComboBox<String> cmbCargo;
	private JComboBox<String> cmbPlaneta;
	private JTextField txtNombre;
	private JSpinner spnAntiguedad;
	private JSpinner spnPorcentajeAdicional;
	private JButton btnInstanciarNave;
	private JButton btnAgregarTripulante;
	private JLabel lblNaveActual;
	private JLabel lblCostoTotalSalarios;
	private JLabel lblError;
	private JTable tablaTripulantes;
	private DefaultTableModel modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCreacion frame = new VentanaCreacion();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCreacion() {
		setTitle("Gestión de Nave y Tripulación (MVC)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		this.panelContenedor = new JPanel();
		this.panelContenedor.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.panelContenedor.setLayout(new BorderLayout(0, 5));
		setContentPane(this.panelContenedor);

		this.panelPrincipal = new JPanel();
		this.panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.panelPrincipal.setLayout(new GridLayout(1, 2, 12, 0));
		this.panelContenedor.add(this.panelPrincipal, BorderLayout.CENTER);

		this.panelCreacion = new JPanel();
		this.panelCreacion.setBorder(BorderFactory.createTitledBorder("Sección de Creación"));
		this.panelCreacion.setLayout(new BorderLayout(0, 10));
		this.panelPrincipal.add(this.panelCreacion);

		this.panelInstanciarNave = new JPanel();
		this.panelInstanciarNave.setBorder(BorderFactory.createTitledBorder("1. Instanciar Nave"));
		this.panelInstanciarNave.setLayout(new GridBagLayout());
		this.panelInstanciarNave.setPreferredSize(new Dimension(0, 150));
		this.panelCreacion.add(this.panelInstanciarNave, BorderLayout.NORTH);

		GridBagConstraints gbcLblTipoNave = new GridBagConstraints();
		gbcLblTipoNave.insets = new Insets(5, 5, 5, 8);
		gbcLblTipoNave.anchor = GridBagConstraints.WEST;
		gbcLblTipoNave.gridx = 0;
		gbcLblTipoNave.gridy = 0;
		this.panelInstanciarNave.add(new JLabel("Tipo de Nave:"), gbcLblTipoNave);

		GridBagConstraints gbcCmbTipoNave = new GridBagConstraints();
		gbcCmbTipoNave.insets = new Insets(5, 3, 5, 5);
		gbcCmbTipoNave.fill = GridBagConstraints.HORIZONTAL;
		gbcCmbTipoNave.weightx = 1.0;
		gbcCmbTipoNave.gridx = 1;
		gbcCmbTipoNave.gridy = 0;
		this.cmbTipoNave = new JComboBox<String>(new String[] { "Carguero", "Combate", "Exploradora" });
		this.panelInstanciarNave.add(this.cmbTipoNave, gbcCmbTipoNave);

		GridBagConstraints gbcBtnInstanciarNave = new GridBagConstraints();
		gbcBtnInstanciarNave.insets = new Insets(8, 5, 5, 5);
		gbcBtnInstanciarNave.gridwidth = 2;
		gbcBtnInstanciarNave.gridx = 0;
		gbcBtnInstanciarNave.gridy = 1;
		this.btnInstanciarNave = new JButton("Instanciar Nave");
		this.btnInstanciarNave.setActionCommand(ACCION_INSTANCIAR);
		this.panelInstanciarNave.add(this.btnInstanciarNave, gbcBtnInstanciarNave);

		this.panelCrearTripulante = new JPanel();
		this.panelCrearTripulante.setBorder(BorderFactory.createTitledBorder("2. Crear Tripulante"));
		this.panelCrearTripulante.setLayout(new GridBagLayout());
		this.panelCreacion.add(this.panelCrearTripulante, BorderLayout.CENTER);

		GridBagConstraints gbcLblNombre = new GridBagConstraints();
		gbcLblNombre.insets = new Insets(4, 5, 4, 8);
		gbcLblNombre.anchor = GridBagConstraints.WEST;
		gbcLblNombre.gridx = 0;
		gbcLblNombre.gridy = 0;
		this.panelCrearTripulante.add(new JLabel("Nombre:"), gbcLblNombre);

		GridBagConstraints gbcTxtNombre = new GridBagConstraints();
		gbcTxtNombre.insets = new Insets(4, 3, 4, 5);
		gbcTxtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNombre.weightx = 1.0;
		gbcTxtNombre.gridx = 1;
		gbcTxtNombre.gridy = 0;
		this.txtNombre = new JTextField();
		this.txtNombre.setColumns(12);
		this.panelCrearTripulante.add(this.txtNombre, gbcTxtNombre);

		GridBagConstraints gbcLblCargo = new GridBagConstraints();
		gbcLblCargo.insets = new Insets(4, 5, 4, 8);
		gbcLblCargo.anchor = GridBagConstraints.WEST;
		gbcLblCargo.gridx = 0;
		gbcLblCargo.gridy = 1;
		this.panelCrearTripulante.add(new JLabel("Cargo:"), gbcLblCargo);

		GridBagConstraints gbcCmbCargo = new GridBagConstraints();
		gbcCmbCargo.insets = new Insets(4, 3, 4, 5);
		gbcCmbCargo.fill = GridBagConstraints.HORIZONTAL;
		gbcCmbCargo.weightx = 1.0;
		gbcCmbCargo.gridx = 1;
		gbcCmbCargo.gridy = 1;
		this.cmbCargo = new JComboBox<String>(
				new String[] { "Alferez", "Capitan", "Consejero", "Teniente" });
		this.panelCrearTripulante.add(this.cmbCargo, gbcCmbCargo);

		GridBagConstraints gbcLblAntiguedad = new GridBagConstraints();
		gbcLblAntiguedad.insets = new Insets(4, 5, 4, 8);
		gbcLblAntiguedad.anchor = GridBagConstraints.WEST;
		gbcLblAntiguedad.gridx = 0;
		gbcLblAntiguedad.gridy = 2;
		this.panelCrearTripulante.add(new JLabel("Antigüedad (años):"), gbcLblAntiguedad);

		GridBagConstraints gbcSpnAntiguedad = new GridBagConstraints();
		gbcSpnAntiguedad.insets = new Insets(4, 3, 4, 5);
		gbcSpnAntiguedad.fill = GridBagConstraints.HORIZONTAL;
		gbcSpnAntiguedad.gridx = 1;
		gbcSpnAntiguedad.gridy = 2;
		this.spnAntiguedad = new JSpinner(new SpinnerNumberModel(
				Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		((JSpinner.DefaultEditor) this.spnAntiguedad.getEditor()).getTextField()
				.setHorizontalAlignment(JTextField.LEFT);
		this.panelCrearTripulante.add(this.spnAntiguedad, gbcSpnAntiguedad);

		GridBagConstraints gbcLblPorcentajeAdicional = new GridBagConstraints();
		gbcLblPorcentajeAdicional.insets = new Insets(4, 5, 4, 8);
		gbcLblPorcentajeAdicional.anchor = GridBagConstraints.WEST;
		gbcLblPorcentajeAdicional.gridx = 0;
		gbcLblPorcentajeAdicional.gridy = 3;
		this.panelCrearTripulante.add(new JLabel("Porcentaje Adicional (%):"), gbcLblPorcentajeAdicional);

		GridBagConstraints gbcSpnPorcentajeAdicional = new GridBagConstraints();
		gbcSpnPorcentajeAdicional.insets = new Insets(4, 3, 4, 5);
		gbcSpnPorcentajeAdicional.fill = GridBagConstraints.HORIZONTAL;
		gbcSpnPorcentajeAdicional.weightx = 1.0;
		gbcSpnPorcentajeAdicional.gridx = 1;
		gbcSpnPorcentajeAdicional.gridy = 3;
		this.spnPorcentajeAdicional = new JSpinner(new SpinnerNumberModel(
				Double.valueOf(0.0), Double.valueOf(0.0), null, Double.valueOf(0.1)));
		this.spnPorcentajeAdicional.setEditor(new JSpinner.NumberEditor(this.spnPorcentajeAdicional, "0.0##"));
		((JSpinner.DefaultEditor) this.spnPorcentajeAdicional.getEditor()).getTextField()
				.setHorizontalAlignment(JTextField.LEFT);
		this.panelCrearTripulante.add(this.spnPorcentajeAdicional, gbcSpnPorcentajeAdicional);

		GridBagConstraints gbcLblPlaneta = new GridBagConstraints();
		gbcLblPlaneta.insets = new Insets(4, 5, 4, 8);
		gbcLblPlaneta.anchor = GridBagConstraints.WEST;
		gbcLblPlaneta.gridx = 0;
		gbcLblPlaneta.gridy = 4;
		this.panelCrearTripulante.add(new JLabel("Planeta:"), gbcLblPlaneta);

		GridBagConstraints gbcCmbPlaneta = new GridBagConstraints();
		gbcCmbPlaneta.insets = new Insets(4, 3, 4, 5);
		gbcCmbPlaneta.fill = GridBagConstraints.HORIZONTAL;
		gbcCmbPlaneta.weightx = 1.0;
		gbcCmbPlaneta.gridx = 1;
		gbcCmbPlaneta.gridy = 4;
		this.cmbPlaneta = new JComboBox<String>(new String[] { "Marte", "Tierra", "Vulcano" });
		this.panelCrearTripulante.add(this.cmbPlaneta, gbcCmbPlaneta);

		GridBagConstraints gbcBtnAgregarTripulante = new GridBagConstraints();
		gbcBtnAgregarTripulante.insets = new Insets(10, 5, 5, 5);
		gbcBtnAgregarTripulante.gridwidth = 2;
		gbcBtnAgregarTripulante.gridx = 0;
		gbcBtnAgregarTripulante.gridy = 5;
		this.btnAgregarTripulante = new JButton("Crear y Asignar Tripulante");
		this.btnAgregarTripulante.setActionCommand(ACCION_AGREGAR);
		this.panelCrearTripulante.add(this.btnAgregarTripulante, gbcBtnAgregarTripulante);

		this.panelTripulantes = new JPanel();
		this.panelTripulantes.setBorder(BorderFactory.createTitledBorder("Sección de Tripulantes"));
		this.panelTripulantes.setLayout(new BorderLayout(0, 8));
		this.panelPrincipal.add(this.panelTripulantes);

		JLabel lblTituloTabla = new JLabel("3. Lista de Tripulantes y Salarios");
		this.panelTripulantes.add(lblTituloTabla, BorderLayout.NORTH);

		this.modeloTabla = new DefaultTableModel(
				new Object[][] {},
				new String[] { "Nombre", "Cargo", "Antigüedad", "Adicional %", "Planeta", "Salario ($)" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.tablaTripulantes = new JTable(this.modeloTabla);
		this.tablaTripulantes.setFillsViewportHeight(true);
		JScrollPane scrollPaneTripulantes = new JScrollPane(this.tablaTripulantes);
		this.panelTripulantes.add(scrollPaneTripulantes, BorderLayout.CENTER);

		this.panelResumen = new JPanel();
		this.panelResumen.setLayout(new GridLayout(2, 1, 0, 2));
		this.lblNaveActual = new JLabel("Nave Actual: Sin nave instanciada");
		this.panelResumen.add(this.lblNaveActual);
		this.lblCostoTotalSalarios = new JLabel("Costo total de salarios: $0");
		this.panelResumen.add(this.lblCostoTotalSalarios);
		this.panelTripulantes.add(this.panelResumen, BorderLayout.SOUTH);

		this.lblError = new JLabel(" ");
		this.lblError.setForeground(Color.RED);
		this.panelContenedor.add(this.lblError, BorderLayout.SOUTH);

		this.btnAgregarTripulante.setActionCommand(AGREGAR_TRIPULANTE);
		this.btnInstanciarNave.setActionCommand(INSTANCIAR_NAVE);
	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.btnInstanciarNave.addActionListener(listener);
		this.btnAgregarTripulante.addActionListener(listener);
	}

	@Override
	public String getTipoNave() {
		return (String) this.cmbTipoNave.getSelectedItem();
	}

	@Override
	public String getNombreTripulante() {
		return this.txtNombre.getText();
	}

	@Override
	public String getCargoTripulante() {
		return (String) this.cmbCargo.getSelectedItem();
	}

	@Override
	public int getAntiguedad() {
		return ((Integer) this.spnAntiguedad.getValue()).intValue();
	}

	@Override
	public double getPorcentajeAdicional() {
		return ((Double) this.spnPorcentajeAdicional.getValue()).doubleValue();
	}

	@Override
	public String getPlaneta() {
		return (String) this.cmbPlaneta.getSelectedItem();
	}

	@Override
	public void agregarFilaTripulante(String nombre, String cargo, int antiguedad, double porcentajeAdicional, String planeta, double salario) {
		NumberFormat formatoNumero = NumberFormat.getNumberInstance(Locale.of("es", "AR"));
		formatoNumero.setMaximumFractionDigits(2);
		this.modeloTabla.addRow(new Object[] {
				nombre,
				cargo,
				Integer.valueOf(antiguedad),
				Double.valueOf(porcentajeAdicional),
				planeta,
				"$" + formatoNumero.format(salario)
		});
	}

	@Override
	public void actualizarCosto(double costoTotalSalarios) {
		NumberFormat formatoNumero = NumberFormat.getNumberInstance(Locale.of("es", "AR"));
		formatoNumero.setMaximumFractionDigits(2);
		this.lblCostoTotalSalarios.setText("Costo total de salarios: $" + formatoNumero.format(costoTotalSalarios));
	}

	@Override
	public void actualizarNave(String tipoNave) {
		this.lblNaveActual.setText("Nave Actual: " + tipoNave);
	}

	@Override
	public void limpiarFormularioTripulante() {
		this.txtNombre.setText("");
		this.cmbCargo.setSelectedIndex(0);
		this.spnAntiguedad.setValue(Integer.valueOf(0));
		this.spnPorcentajeAdicional.setValue(Double.valueOf(0.0));
		this.cmbPlaneta.setSelectedIndex(0);
	}

	@Override
	public void mostrarError(String error) {
		this.lblError.setText(error);
	}

	@Override
	public void limpiarError() {
		this.lblError.setText(" ");
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
}

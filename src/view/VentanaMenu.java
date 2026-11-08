package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.acceso.Usuario;

public class VentanaMenu extends JFrame implements IVentanaMenu {

	private static final long serialVersionUID = 1L;
	private static final Color COLOR_FONDO = new Color(43, 47, 51);
	private static final Color COLOR_BOTON = new Color(65, 71, 77);
	private static final Color COLOR_TEXTO = Color.WHITE;

	private JPanel panelPrincipal;
	private JPanel panelCabecera;
	private JPanel panelAccesos;
	private JPanel panelPie;
	private JLabel lblTitulo;
	private JLabel lblBienvenida;
	private JLabel lblOperacion;
	private JButton btnCreacion;
	private JButton btnControl;
	private JButton btnConcurrencia;
	private JButton btnCerrarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setTitle("Menú Principal (MVC)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 680);
		setMinimumSize(getSize());

		this.panelPrincipal = new JPanel();
		this.panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.panelPrincipal.setBackground(COLOR_FONDO);
		this.panelPrincipal.setLayout(new BorderLayout(0, 10));
		setContentPane(this.panelPrincipal);

		this.panelCabecera = new JPanel();
		this.panelCabecera.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK),
				new EmptyBorder(10, 10, 10, 10)));
		this.panelCabecera.setBackground(COLOR_FONDO);
		this.panelCabecera.setLayout(new GridLayout(2, 1, 0, 2));
		this.panelPrincipal.add(this.panelCabecera, BorderLayout.NORTH);

		this.lblTitulo = new JLabel("SISTEMA DE CONTROL DE LA NAVE");
		this.lblTitulo.setForeground(COLOR_TEXTO);
		this.lblTitulo.setFont(new Font("Dialog", Font.BOLD, 32));
		this.lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCabecera.add(this.lblTitulo);

		this.lblBienvenida = new JLabel("Bienvenido, Operador: ");
		this.lblBienvenida.setForeground(COLOR_TEXTO);
		this.lblBienvenida.setFont(new Font("Dialog", Font.PLAIN, 20));
		this.lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCabecera.add(this.lblBienvenida);

		this.panelAccesos = new JPanel();
		this.panelAccesos.setBorder(new EmptyBorder(10, 15, 10, 15));
		this.panelAccesos.setBackground(COLOR_FONDO);
		this.panelAccesos.setLayout(new GridLayout(3, 1, 0, 15));
		this.panelPrincipal.add(this.panelAccesos, BorderLayout.CENTER);

		this.btnCreacion = crearBoton(
				"<html><center><b>1. Creación de Nave y Tripulación</b>"
						+ "<br><font size=\"4\">Configuración inicial de la nave, alta y asignación de tripulantes.</font>"
						+ "</center></html>");
		this.panelAccesos.add(this.btnCreacion);

		this.btnControl = crearBoton(
				"<html><center><b>2. Control de la Nave</b>"
						+ "<br><font size=\"4\">Mando central, travesía espacial en el mapa, recursos y bitácora.</font>"
						+ "</center></html>");
		this.panelAccesos.add(this.btnControl);

		this.btnConcurrencia = crearBoton(
				"<html><center><b>3. Visor Recóndito (Concurrencia)</b>"
						+ "<br><font size=\"4\">Visualización en tiempo real del universo paralelo y la plataforma de carga.</font>"
						+ "</center></html>");
		this.panelAccesos.add(this.btnConcurrencia);

		this.panelPie = new JPanel();
		this.panelPie.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK),
				new EmptyBorder(8, 10, 8, 10)));
		this.panelPie.setBackground(COLOR_FONDO);
		this.panelPie.setLayout(new BorderLayout(0, 5));
		this.panelPrincipal.add(this.panelPie, BorderLayout.SOUTH);

		JPanel panelCerrarSesion = new JPanel(new BorderLayout());
		panelCerrarSesion.setOpaque(false);
		this.panelPie.add(panelCerrarSesion, BorderLayout.NORTH);

		this.btnCerrarSesion = new JButton("Cerrar Sesión");
		this.btnCerrarSesion.setFont(new Font("Dialog", Font.PLAIN, 16));
		this.btnCerrarSesion.setForeground(COLOR_TEXTO);
		this.btnCerrarSesion.setBackground(COLOR_BOTON);
		this.btnCerrarSesion.setFocusPainted(false);
		panelCerrarSesion.add(this.btnCerrarSesion, BorderLayout.EAST);

		this.lblOperacion = new JLabel("Operación: Panel Principal");
		this.lblOperacion.setForeground(COLOR_TEXTO);
		this.lblOperacion.setFont(new Font("Dialog", Font.PLAIN, 18));
		this.lblOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelPie.add(this.lblOperacion, BorderLayout.SOUTH);

		this.btnCreacion.setActionCommand(VISTA_CREACION);
		this.btnControl.setActionCommand(VISTA_CONTROL);
		this.btnConcurrencia.setActionCommand(VISTA_CONCURRENCIA);
		this.btnCerrarSesion.setActionCommand(CERRAR_SESION);
	}

	private JButton crearBoton(String texto) {
		JButton boton = new JButton(texto);
		boton.setFont(new Font("Dialog", Font.BOLD, 22));
		boton.setForeground(COLOR_TEXTO);
		boton.setBackground(COLOR_BOTON);
		boton.setFocusPainted(false);
		boton.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(125, 130, 135)),
				new EmptyBorder(12, 12, 12, 12)));
		return boton;
	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.btnCreacion.addActionListener(listener);
		this.btnControl.addActionListener(listener);
		this.btnConcurrencia.addActionListener(listener);
		this.btnCerrarSesion.addActionListener(listener);
	}

	@Override
	public void arranca(Usuario usuario) {
		if (usuario != null) {
			this.lblBienvenida.setText("Bienvenido, Operador: " + usuario.getNombre());
		}
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void cierra() {
		dispose();
	}
}

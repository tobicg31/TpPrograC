package view;

import java.nio.file.Path;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controller.ControladorAcceso;
import model.acceso.UsuarioDAOSql;

public class VentanaLogin extends JFrame implements IVentanaLogin {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPrincipal;
	private JPanel PanelCampos;
	private JPanel PanelBotones;
	private JPanel PanelInferior;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JLabel lblError;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					new ControladorAcceso(frame, new UsuarioDAOSql(Path.of("usuarios.db")));
					frame.arranca();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		this.PanelPrincipal = new JPanel();
		this.PanelPrincipal.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(this.PanelPrincipal);
		this.PanelPrincipal.setLayout(new BorderLayout(0, 8));

		this.PanelCampos = new JPanel();
		this.PanelCampos.setLayout(new GridBagLayout());
		this.PanelPrincipal.add(this.PanelCampos, BorderLayout.CENTER);

		GridBagConstraints gbcLblUsuario = new GridBagConstraints();
		gbcLblUsuario.insets = new Insets(3, 3, 3, 10);
		gbcLblUsuario.anchor = GridBagConstraints.WEST;
		gbcLblUsuario.gridx = 0;
		gbcLblUsuario.gridy = 0;
		this.lblUsuario = new JLabel("USUARIO");
		this.PanelCampos.add(this.lblUsuario, gbcLblUsuario);

		GridBagConstraints gbcTxtUsuario = new GridBagConstraints();
		gbcTxtUsuario.insets = new Insets(3, 3, 3, 3);
		gbcTxtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtUsuario.weightx = 1.0;
		gbcTxtUsuario.gridx = 1;
		gbcTxtUsuario.gridy = 0;
		this.txtUsuario = new JTextField();
		this.PanelCampos.add(this.txtUsuario, gbcTxtUsuario);
		this.txtUsuario.setColumns(10);

		GridBagConstraints gbcLblPassword = new GridBagConstraints();
		gbcLblPassword.insets = new Insets(3, 3, 3, 10);
		gbcLblPassword.anchor = GridBagConstraints.WEST;
		gbcLblPassword.gridx = 0;
		gbcLblPassword.gridy = 1;
		this.lblPassword = new JLabel("CONTRASEÑA");
		this.PanelCampos.add(this.lblPassword, gbcLblPassword);

		GridBagConstraints gbcTxtPassword = new GridBagConstraints();
		gbcTxtPassword.insets = new Insets(3, 3, 3, 3);
		gbcTxtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPassword.weightx = 1.0;
		gbcTxtPassword.gridx = 1;
		gbcTxtPassword.gridy = 1;
		this.txtPassword = new JPasswordField();
		this.PanelCampos.add(this.txtPassword, gbcTxtPassword);
		this.txtPassword.setColumns(10);

		this.PanelBotones = new JPanel();
		this.PanelBotones.setLayout(new GridBagLayout());
		this.PanelInferior = new JPanel();
		this.PanelInferior.setLayout(new BorderLayout(0, 3));
		this.PanelPrincipal.add(this.PanelInferior, BorderLayout.SOUTH);
		this.PanelInferior.add(this.PanelBotones, BorderLayout.NORTH);

		GridBagConstraints gbcBtnLogin = new GridBagConstraints();
		gbcBtnLogin.anchor = GridBagConstraints.WEST;
		gbcBtnLogin.weightx = 1.0;
		gbcBtnLogin.insets = new Insets(0, 3, 0, 3);
		gbcBtnLogin.gridx = 0;
		gbcBtnLogin.gridy = 0;
		this.btnLogin = new JButton("LOGIN");
		this.PanelBotones.add(this.btnLogin, gbcBtnLogin);

		GridBagConstraints gbcBtnRegister = new GridBagConstraints();
		gbcBtnRegister.anchor = GridBagConstraints.EAST;
		gbcBtnRegister.insets = new Insets(0, 3, 0, 3);
		gbcBtnRegister.gridx = 1;
		gbcBtnRegister.gridy = 0;
		this.btnRegister = new JButton("REGISTRARSE");
		this.PanelBotones.add(this.btnRegister, gbcBtnRegister);

		this.lblError = new JLabel(" ");
		this.lblError.setForeground(Color.RED);
		this.PanelInferior.add(this.lblError, BorderLayout.SOUTH);

		this.btnLogin.setActionCommand(LOGIN);
		this.btnRegister.setActionCommand(REGISTRAR);
	}

	@Override
	public void setActionListener(ActionListener listener) {
		this.btnLogin.addActionListener(listener);
		this.btnRegister.addActionListener(listener);
	}

	@Override
	public void mostrarError(String error) {
		this.lblError.setText(error);
	}

	@Override
	public void limpiarCampos() {
		this.txtPassword.setText("");
		;
		this.txtUsuario.setText("");
	}

	@Override
	public void limpiarError() {
		this.lblError.setForeground(Color.RED);
		this.lblError.setText("");
	}

	@Override
	public String getUsuario() {
		return this.txtUsuario.getText();
	}

	@Override
	public String getContrasenia() {
		return new String(this.txtPassword.getPassword());
	}

	@Override
	public void mostrarMensaje(String mensaje) {
		this.lblError.setForeground(new Color(0, 128, 0));
		this.lblError.setText(mensaje);
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

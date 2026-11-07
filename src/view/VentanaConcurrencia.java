package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.FlowLayout;

import model.concurrencia.ObserverPlataforma;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ControladorConcurrencia;
import model.concurrencia.PlataformaDeCarga;

public class VentanaConcurrencia extends JFrame implements IVentanaConcurrencia,ObserverPlataforma {
	private JList<String> list;      // antes: JList
	private JList<String> list_1;    // antes: JList
	private final DefaultListModel<String> modeloNaves = new DefaultListModel<>();
	private final DefaultListModel<String> modeloGeneradores = new DefaultListModel<>();
	private static final long serialVersionUID = 1L;
	private JPanel PanelGeneral;
	private JPanel PanelColumnas;
	private JPanel PanelNaves;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_3;
	private JPanel PanelLogs;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnStart;
	private JPanel PanelGeneradores;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_1;
	private JPanel PanelBotón;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                VentanaConcurrencia frame = new VentanaConcurrencia();
                PlataformaDeCarga modelo = new PlataformaDeCarga(3);   // capacidad del depósito
                new ControladorConcurrencia(frame, modelo);
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
	public VentanaConcurrencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 340);
		this.PanelGeneral = new JPanel();
		this.PanelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.PanelGeneral);
		this.PanelGeneral.setLayout(new BorderLayout(0, 0));
		
		this.PanelColumnas = new JPanel();
		this.PanelGeneral.add(this.PanelColumnas, BorderLayout.CENTER);
		this.PanelColumnas.setLayout(new GridLayout(1, 3, 15, 0));
		
		this.PanelNaves = new JPanel();
		this.PanelColumnas.add(this.PanelNaves);
		this.PanelNaves.setLayout(new BorderLayout(0, 0));
		
		this.btnNewButton_2 = new JButton("CREAR NAVE");
		this.btnNewButton_2.setMargin(new Insets(0, 14, 0, 14));
		this.PanelNaves.add(this.btnNewButton_2, BorderLayout.SOUTH);
		
		
		this.lblNewLabel_1 = new JLabel("Naves");               
		this.lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER); 
		this.PanelNaves.add(this.lblNewLabel_1, BorderLayout.NORTH);
		
		this.scrollPane_3 = new JScrollPane();
		this.PanelNaves.add(this.scrollPane_3, BorderLayout.CENTER);
		
		this.list = new JList<String>(modeloNaves);
		this.scrollPane_3.setViewportView(this.list);
		
		this.PanelLogs = new JPanel();
		this.PanelColumnas.add(this.PanelLogs);
		this.PanelLogs.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel = new JLabel("LOGS");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.PanelLogs.add(this.lblNewLabel, BorderLayout.NORTH);
		
		this.scrollPane = new JScrollPane();
		this.PanelLogs.add(this.scrollPane, BorderLayout.CENTER);
		
		this.textArea = new JTextArea();
		this.scrollPane.setViewportView(this.textArea);

		this.btnStart = new JButton("EJECUTAR");
		this.btnStart.setMargin(new Insets(0, 14, 0, 14));
		this.PanelLogs.add(this.btnStart, BorderLayout.SOUTH);
		
		this.PanelGeneradores = new JPanel();
		this.PanelColumnas.add(this.PanelGeneradores);
		this.PanelGeneradores.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel_2 = new JLabel("GENERADORES");
		this.lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		this.PanelGeneradores.add(this.lblNewLabel_2, BorderLayout.NORTH);
		
		
		
		this.scrollPane_1 = new JScrollPane();
		this.PanelGeneradores.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.list_1 = new JList<String>(modeloGeneradores);
		this.scrollPane_1.setViewportView(this.list_1);
		
		this.btnNewButton_1 = new JButton("CREAR GENERADOR");
		this.btnNewButton_1.setMargin(new Insets(0, 14, 0, 14));
		this.PanelGeneradores.add(this.btnNewButton_1, BorderLayout.SOUTH);
		
		this.PanelBotón = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.PanelBotón.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.PanelGeneral.add(this.PanelBotón, BorderLayout.SOUTH);
		
		this.btnNewButton = new JButton("VOLVER");
		this.btnNewButton.setMargin(new Insets(0, 14, 0, 14));
		this.PanelBotón.add(this.btnNewButton);

	}
	@Override
public void setActionListener(ActionListener listener) {
    btnStart.setActionCommand("EJECUTAR");
    btnNewButton_2.setActionCommand("CREAR NAVE");
    btnNewButton_1.setActionCommand("CREAR GENERADOR");

    btnStart.addActionListener(listener);
    btnNewButton_2.addActionListener(listener);
    btnNewButton_1.addActionListener(listener);
}

@Override
public boolean validaParametros() {
    int naves = modeloNaves.getSize();
    int generadores = modeloGeneradores.getSize();
    if (naves == 0 || naves != generadores) {
        JOptionPane.showMessageDialog(this,
                "La cantidad de naves y generadores debe ser igual y mayor a 0.",
                "Parámetros inválidos", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

@Override
public void agregarNave(String nombre) { modeloNaves.addElement(nombre); }

@Override
public void agregarGenerador(String nombre) { modeloGeneradores.addElement(nombre); }

@Override
public void actualizar(String evento) {
    // llega desde los hilos; Swing solo se toca desde su propio hilo
    SwingUtilities.invokeLater(() -> textArea.append(evento + "\n"));
}
}

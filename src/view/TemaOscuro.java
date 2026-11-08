package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

final class TemaOscuro {

	private static final Color FONDO = new Color(43, 47, 51);
	private static final Color SUPERFICIE = new Color(65, 71, 77);
	private static final Color CAMPO = new Color(52, 57, 62);
	private static final Color TEXTO = Color.WHITE;
	private static final Color BORDE = new Color(125, 130, 135);

	private TemaOscuro() {
	}

	static void aplicar(JFrame ventana) {
		ventana.getContentPane().setBackground(FONDO);
		aplicar(ventana.getContentPane());
	}

	private static void aplicar(Component componente) {
		if (componente instanceof JPanel) {
			componente.setBackground(FONDO);
			((JPanel) componente).setOpaque(true);
			if (((JPanel) componente).getBorder() instanceof TitledBorder) {
				((TitledBorder) ((JPanel) componente).getBorder()).setTitleColor(TEXTO);
			}
		} else if (componente instanceof JButton) {
			JButton boton = (JButton) componente;
			boton.setForeground(TEXTO);
			boton.setBackground(SUPERFICIE);
			boton.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(BORDE),
					BorderFactory.createEmptyBorder(5, 9, 5, 9)));
			boton.setFocusPainted(false);
			boton.setOpaque(true);
		} else if (componente instanceof JLabel) {
			componente.setForeground(TEXTO);
		} else if (componente instanceof JTextComponent) {
			JTextComponent campo = (JTextComponent) componente;
			campo.setForeground(TEXTO);
			campo.setBackground(CAMPO);
			campo.setCaretColor(TEXTO);
			campo.setSelectionColor(SUPERFICIE);
			campo.setSelectedTextColor(TEXTO);
			campo.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(BORDE),
					BorderFactory.createEmptyBorder(3, 5, 3, 5)));
			campo.setOpaque(true);
		} else if (componente instanceof JComboBox<?>) {
			componente.setForeground(TEXTO);
			componente.setBackground(CAMPO);
			((JComponent) componente).setOpaque(true);
		} else if (componente instanceof JSpinner) {
			componente.setForeground(TEXTO);
			componente.setBackground(CAMPO);
			((JComponent) componente).setOpaque(true);
		} else if (componente instanceof JTable) {
			JTable tabla = (JTable) componente;
			tabla.setForeground(TEXTO);
			tabla.setBackground(CAMPO);
			tabla.setGridColor(BORDE);
			tabla.setSelectionBackground(SUPERFICIE);
			tabla.setSelectionForeground(TEXTO);
			tabla.getTableHeader().setForeground(TEXTO);
			tabla.getTableHeader().setBackground(SUPERFICIE);
			tabla.getTableHeader().setOpaque(true);
			tabla.setOpaque(true);
		} else if (componente instanceof JList<?>) {
			JList<?> lista = (JList<?>) componente;
			lista.setForeground(TEXTO);
			lista.setBackground(CAMPO);
			lista.setSelectionBackground(SUPERFICIE);
			lista.setSelectionForeground(TEXTO);
			lista.setOpaque(true);
		} else if (componente instanceof JScrollPane) {
			JScrollPane scroll = (JScrollPane) componente;
			scroll.setBorder(BorderFactory.createLineBorder(BORDE));
			scroll.getViewport().setBackground(CAMPO);
			scroll.setOpaque(true);
		} else if (componente instanceof JViewport) {
			componente.setBackground(CAMPO);
			((JComponent) componente).setOpaque(true);
		}

		if (componente instanceof Container) {
			for (Component hijo : ((Container) componente).getComponents()) {
				aplicar(hijo);
			}
		}
	}
}

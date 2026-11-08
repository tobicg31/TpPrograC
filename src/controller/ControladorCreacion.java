package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.naves.Nave;
import model.naves.factory.NaveFactory;
import model.tripulantes.Alferez;
import model.tripulantes.Capitan;
import model.tripulantes.Consejero;
import model.tripulantes.Teniente;
import model.tripulantes.Tripulante;
import model.tripulantes.decorator.Liquidable;
import model.tripulantes.decorator.Marciano;
import model.tripulantes.decorator.Vulcano;
import view.IVentanaCreacion;

public class ControladorCreacion implements ActionListener {
	private IVentanaCreacion vista;
	private Nave nave = null;
	private ArrayList<Liquidable> tripulantes;

	public ControladorCreacion(IVentanaCreacion vista) {
		this.vista = vista;
		this.vista.setActionListener(this);
		this.tripulantes = new ArrayList<Liquidable>();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		vista.limpiarError();
		
    switch (e.getActionCommand()) {
      case IVentanaCreacion.AGREGAR_TRIPULANTE:
        agregarTripulante();
      break;
      case IVentanaCreacion.INSTANCIAR_NAVE:
        instanciarNave();
      break;
    }
	}

	private void agregarTripulante() {
		Tripulante tripulante = validarTripulante();
		if(tripulante == null)
			return ;
		if(this.nave == null) {
			vista.mostrarError("Debe instanciar una nave antes de agregar tripulantes");
			return ;
		}
		double salario = 0;
		Liquidable liquidable = null;
		switch(vista.getPlaneta()){
			case "Tierra":
				liquidable = new Vulcano(tripulante);
				break;
			case "Marte":
				liquidable = new Marciano(tripulante);
				break;
			case "Vulcano":
				liquidable = new Vulcano(tripulante);
				break;
			default:
				vista.mostrarError("El planeta no es válido");
				return ;
		}
		this.tripulantes.add(liquidable);
		salario = liquidable.liquidacionDeHaberes();
		vista.agregarFilaTripulante(tripulante.getIdentidad(), tripulante.getCargo(), tripulante.getAntiguedad(), tripulante.getPorcentajeAdicional(), tripulante.getPlaneta(), salario);
		vista.actualizarCosto(vista.getCostoTotalSalarios() + salario);
		vista.limpiarFormularioTripulante();
	}

	private void instanciarNave() {
		String tipoNave = vista.getTipoNave();
		if(tipoNave.isEmpty()) {
			vista.mostrarError("El tipo de nave no peude ser vacío");
			return ;
		}
		if(this.nave != null) {
			vista.mostrarError("Ya se ha instanciado una nave");
			return ;
		}
		this.nave = NaveFactory.getNave(tipoNave);
		if(this.nave == null) {
			vista.mostrarError("El tipo de nave no es válido");
			return ;
		}
		vista.actualizarNave(tipoNave);
		vista.actualizarCosto(0);
	}

	private Tripulante validarTripulante() {
		String nombre = vista.getNombreTripulante();
		String cargo = vista.getCargoTripulante();
		int antiguedad = vista.getAntiguedad();
		double porcentajeAdicional = vista.getPorcentajeAdicional();
		String planeta = vista.getPlaneta();

		if(nombre.isEmpty() || cargo.isEmpty() || planeta.isEmpty()) {
			vista.mostrarError("Los parámetros de texto no deben estar vacíos");
			return null;
		}
		if(porcentajeAdicional <= 0){
			vista.mostrarError("El porcentaje adicional debe ser mayor a 0");
			return null;
		}
		switch(cargo) {
			case "Alferez":
				return new Alferez(nombre, cargo, antiguedad, porcentajeAdicional, planeta);
			case "Teniente":
				return new Teniente(nombre, cargo, antiguedad, porcentajeAdicional, planeta);
			case "Capitan":
				return new Capitan(nombre, cargo, antiguedad, porcentajeAdicional, planeta);
			case "Consejero":
				return new Consejero(nombre, cargo, antiguedad, porcentajeAdicional, planeta);
			default:
				vista.mostrarError("El cargo del tripulante no es válido");
				return null;
		}
	}

}

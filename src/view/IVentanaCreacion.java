package view;

import java.awt.event.ActionListener;

public interface IVentanaCreacion {
	String INSTANCIAR_NAVE = "INSTANCIAR NAVE";
	String AGREGAR_TRIPULANTE = "AGREGAR TRIPULANTE";
	
  void setActionListener(ActionListener listener);
  public String getTipoNave();
	String getNombreTripulante();
	String getCargoTripulante();
	int getAntiguedad();
	double getPorcentajeAdicional();
  String getPlaneta();
	void agregarFilaTripulante(String nombre, String cargo, int antiguedad, double porcentajeAdicional, String planeta, double salario);
	void actualizarCosto(double costoTotalSalarios);
	void actualizarNave(String tipoNave);
	void limpiarFormularioTripulante();
	void mostrarError(String error);
	void limpiarError();
	void arranca();
	void cierra();
}

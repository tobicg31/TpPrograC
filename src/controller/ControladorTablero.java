package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.destinoytablero.CantidadDeElementosSuperaCasillaException;
import model.destinoytablero.Destino;
import model.destinoytablero.DimensionesDeTableroInconsistentesException;
import model.destinoytablero.Tablero;
import model.elementosUniverso.ElementoDelUniverso;
import model.naves.Nave;
import view.IVentanaLogin;
import view.IVentanaTablero;

public class ControladorTablero implements ActionListener{
    private final IVentanaTablero vista;
    private Tablero tablero;
    private Destino destino;
    private final Nave nave;

    

    public ControladorTablero(IVentanaTablero vista, Nave nave) {
        this.vista = vista;
        this.nave = nave;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case IVentanaMision.Mision01:
                crearMision("01");
                break;
            case IVentanaMision.Mision02:
                crearMision("02");
                break;
            case IVentanaMision.Mision03:
                crearMision("03");
                break;    
        }
    }

    
    public void inicalizarTablero(int x, int y){
        try {
            ArrayList<ElementoDelUniverso> elementos = new ArrayList<>();
            //no se si hacer random los elementos en el tablero, o que se pueda elegir que va a haber
            this.tablero = new Tablero(x, y, elementos);
            this.destino = new Destino(tablero);
        } catch (DimensionesDeTableroInconsistentesException e) {
            vista.mostrarError(e.getMessage());
        } catch (CantidadDeElementosSuperaCasillaException e){
            vista.mostrarError(e.getMessage());
        }
    }
    
    public void mostrarTablero(){

    }

    public void setObjetivo(){
        //busca el objetivo mas cercano (tablero.obtenerObjetivo() ) y
        //le dice a la nave principal que mision arrancar
    }

    public void turnoNave(){
        //no estoy tan seguro de esta pero bueno
    }

    public void turnoTablero(){
        //es llamar a turnoDestino del Destino xd
    }
    public void crearMision(String mision){ //VENTANA DONDE SE SELECCIONA LA MISION
        //
        
    }
}

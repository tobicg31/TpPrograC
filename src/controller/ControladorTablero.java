package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.destinoytablero.CantidadDeElementosSuperaCasillaException;
import model.destinoytablero.Destino;
import model.destinoytablero.DimensionesDeTableroInconsistentesException;
import model.destinoytablero.Tablero;
import model.elementosUniverso.ElementoDelUniverso;
import view.IVentanaTablero;

public class ControladorTablero implements ActionListener{
    private final IVentanaTablero vista;
    private Tablero tablero;
    private Destino destino;

    

    public ControladorTablero(IVentanaTablero vista) {
        this.vista = vista;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
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
    
    public void mostrarTablero(Tablero tablero){

    }

    public void turnoNave(Tablero tablero){

    }

    public void turnoTablero(Tablero tablero){

    }
}

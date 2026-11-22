package model.misiones;

import model.asistentes.Asistente;
import model.destinoytablero.Destino;
import model.destinoytablero.Posicion;
import model.destinoytablero.Tablero;
import model.elementosUniverso.ElementoDelUniverso;
import model.elementosUniverso.excepciones.NaveInoperativaException;
import model.misiones.excepciones.NaveMantenimientoException;
import model.misiones.excepciones.NaveSinRecursosException;

/**
 * Esta clase representa la abstracción de una misión que puede ser ejecutada
 * por una nave.
 * 
 * <b>Invariantes de clase:</b>
 * - combustibleNecesario == 4
 * - desgaste == 4
 */
public abstract class Mision {
    protected String nombre;
    protected int combustibleNecesario, desgaste, energiaNecesaria;
    protected Asistente asistente;
    protected boolean misionTerminada = false;
    protected boolean naveViva = true;
    protected Tablero tablero;
    protected Destino destino;
    protected int xRestantes, yRestantes;
    protected int dirX, dirY;
    protected Posicion posObjetivo;
    protected String error;

    private boolean invariante() {
        return combustibleNecesario == 4 && desgaste == 4;
    }

    public Mision(Tablero tablero, Destino destino, int e) { //no sabemos si pasar aca el destino
        this.combustibleNecesario = 4;
        this.desgaste = 4;
        this.asistente = null;
        this.tablero = tablero;
        this.destino = destino;
        this.energiaNecesaria = e;
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
    }

    public String getNombreMision() {
        return nombre;
    }

    /**
     * Este método permite preparar la nave para ejecutar la misión.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para preparar la
     *          misión.
     * @throws NaveSinRecursosException   En caso de no cumplir con los recursos
     *                                    necesarios para ejecutar la misión.
     * @throws NaveMantenimientoException En caso de que la nave requiera
     *                                    mantenimiento.
     */
    public void preparar(Asistente asistente) throws NaveSinRecursosException, NaveMantenimientoException {
        assert asistente.getNave() != null : "La nave no puede ser nula";
        System.out.println("preparo la nave...");
        if (!((asistente.getNave().getCombustible() - this.combustibleNecesario >= 0) && (asistente.getNave().getDesgaste() + this.desgaste <= 100))) {
            throw new NaveSinRecursosException("Fallo de recursos");
        } else if ((asistente.getNave().requiereMantenimiento())) {
            throw new NaveMantenimientoException("La nave requiere mantenimiento");
        } else {
            System.out.println("Nave preparada!");
        }
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
        //CALCULO RUTA OBJETIVO
        //hay que llamar a obtenerObjetivo() del Tablero.
        Posicion posObjetivo = this.tablero.obtenerObjetivo();
        this.posObjetivo = posObjetivo;
        Posicion posNaveInicial = this.tablero.getPosicionNave();

        this.xRestantes = posObjetivo.getX()-posNaveInicial.getX();
        this.dirX = this.xRestantes / Math.abs(this.xRestantes);
        this.xRestantes = Math.abs(this.xRestantes);
        this.yRestantes = posObjetivo.getY()-posNaveInicial.getY();
        this.dirY = this.yRestantes / Math.abs(this.yRestantes);
        this.yRestantes = Math.abs(this.yRestantes);
    }


    /**
     * Este método permite ejecutar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para ejecutar la
     *          misión.
     * @return Realiza la ejecución de la misión, actualizando los recursos de la
     *         nave según los requerimientos de la misión.
     */
    public void ejecutar(Asistente asistente) {
        ElementoDelUniverso posActual;
        Posicion actualNave;
        assert asistente.getNave() != null : "La nave no puede ser nula";
        //gasto recursos de la mision:
        
        asistente.NaveModificarEnergia(-this.energiaNecesaria);
        asistente.NaveModificarCombultible(-this.combustibleNecesario);
        asistente.getNave().setDesgaste(asistente.getNave().getDesgaste() + this.desgaste);
        
        while (naveViva && !misionTerminada){
            actualNave = this.tablero.getPosicionNave();
            //turno nave:
            //inspeccion posicion actual, hay que usar inspeccionarPosicion del Tablero
            posActual = this.tablero.inspeccionarPosicion();
            //si devuelve null, no hay nada
            //si devuelve un elemento, hay que llamar a interactua del elemento
            try {
                if (posActual != null){
                    posActual.interactuar(this.asistente);
                }
                //escaneo:
                //radar corto alcanze, hay que usar observarAlrededores del Tablero              
                //planificacion:
                //decide si moverse uno o 2 lugares, por el motor
                try {
                    if (xRestantes > 0){
                        Posicion siguiente = new Posicion(actualNave.getX()+dirX, actualNave.getY());
                        if (this.tablero.estaLibre(siguiente)){
                            asistente.saltar();
                            this.tablero.moverNave(siguiente);
                            asistente.NaveModificarEnergia(0);
                            asistente.NaveModificarCombultible(-2);
                            this.xRestantes -=1;
                        } else {
                            try {
                                asistente.saltarWarp();
                                if (this.xRestantes > 1){
                                    this.xRestantes -=2;
                                    siguiente = new Posicion(actualNave.getX()+ 2*dirX, actualNave.getY());
                                }
                                else {
                                    this.xRestantes -=1;
                                    siguiente = new Posicion(actualNave.getX()+ dirX, actualNave.getY()+dirY);
                                    this.yRestantes -=1;
                                }
                                 this.tablero.moverNave(siguiente);
                                asistente.NaveModificarEnergia(0);
                                asistente.NaveModificarCombultible(-2);
                            } catch (NaveInoperativaException e) {
                                this.error = e.getMessage();
                                asistente.saltar();
                                this.tablero.moverNave(siguiente);
                                asistente.NaveModificarEnergia(0);
                                asistente.NaveModificarCombultible(-2);
                                this.xRestantes -=1;
                        }
                    }}
                    else if (yRestantes > 0){
                        actualNave = this.tablero.getPosicionNave();
                        Posicion siguiente = new Posicion(actualNave.getX(), actualNave.getY()+dirY);
                        if (this.tablero.estaLibre(siguiente)){
                            asistente.saltar();
                            this.tablero.moverNave(siguiente);
                            asistente.NaveModificarEnergia(0);
                            asistente.NaveModificarCombultible(-2);
                            this.yRestantes -=1;
                        } else {
                            try {
                                if (yRestantes > 1){
                                    asistente.saltarWarp();
                                    this.yRestantes -=2;  
                                    siguiente = new Posicion(actualNave.getX(), actualNave.getY()+ 2*dirY);
                                    this.tablero.moverNave(siguiente);
                                asistente.NaveModificarEnergia(0);
                                asistente.NaveModificarCombultible(-2);
                                }
                            } catch (NaveInoperativaException e) {
                                this.error = e.getMessage();
                                asistente.saltar();
                                this.tablero.moverNave(siguiente);
                                asistente.NaveModificarEnergia(0);
                                asistente.NaveModificarCombultible(-2);
                                this.yRestantes -=1;
                            }  
                        }
                    }
                }finally{
                    //turno tablero:
                    //hay q llamar a turnoDestino del Destino
                    
                    try{
                        Thread.sleep(1000);
                        this.destino.turnoDestino();
                        Thread.sleep(1000);
                    } catch(Exception e){
                        System.out.println("Error en el turno del destino: " + e.getMessage());
                    }
                }
                } catch (NaveInoperativaException e) {
                    this.error = e.getMessage();
                    naveViva = false;
                }
                if (posObjetivo.equals(actualNave))
                    misionTerminada = true;
            }
        //se llego a destino
        //habria q hacer un metodo abstracto para q cada mision decida que hacer en destino
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
    }

    /**
     * Este método permite evaluar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para evaluar la
     *          misión.
     */
    public abstract void evaluar(Asistente asistente); // fecha, recursos, que hizo

    /**
     * Este método permite cerrar la misión utilizando la nave proporcionada.
     * <b>PRE:</b>
     * - n != null
     * 
     * @param n Este parámetro representa la nave que se utilizará para cerrar la
     *          misión.
     */
    public void cerrar(Asistente asistente) {
    }

    /**
     * Este método permite ejecutar una misión utilizando la nave proporcionada.
     * 
     * @param n Este parámetro representa la nave que se utilizará para ejecutar la
     *          misión, no puede ser nulo.
     * @throws NaveSinRecursosException   Esta excepción se lanza si la nave no
     *                                    tiene suficientes recursos para ejecutar
     *                                    la misión.
     * @throws NaveMantenimientoException Esta excepción se lanza si la nave
     *                                    requiere mantenimiento.
     * @return Realiza el paso a paso de la ejecución de la misión, incluyendo
     *         preparación, ejecución, evaluación y cierre, utilizando la nave
     *         proporcionada.
     */
    public final void ejecutarMision(Asistente a) throws NaveSinRecursosException, NaveMantenimientoException {
        assert a != null : "El asistente no puede ser nula";
        preparar(a);
        ejecutar(a);
        evaluar(a);
        cerrar(a);
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
    }

    /**
     * Este método permite asociar un asistente a la misión.
     * <b>PRE:</b>
     * - asistente != null
     * 
     * @param asistente Este parámetro representa el asistente que se desea asociar
     *                  a la misión, no puede ser nulo.
     * @return Asocia el asistente proporcionado a la misión.
     */
    public void setAsistente(Asistente asistente) {
        assert asistente != null : "El asistente no puede ser nulo";
        this.asistente = asistente;
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
    }

    /**
     * Este método permite establecer el nombre de la misión.
     * <b>PRE:</b>
     * - nombre != null
     * 
     * @param nombre Este parámetro representa el nombre que se desea asignar a la
     *               misión, no puede ser nulo.
     * @return Establece el nombre de la misión con el valor proporcionado.
     */
    public void setNombre(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        assert invariante() : "El combustible debe ser 4 y el desgaste debe ser 4";
    }

}

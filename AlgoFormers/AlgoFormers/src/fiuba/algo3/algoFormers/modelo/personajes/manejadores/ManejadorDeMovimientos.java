package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeMovimientos {
	
	private static int NULO=0;
	private static int UNICO=1;
	private int movimientosRestantes; 
	private int movimientosTotales;
	
	public ManejadorDeMovimientos(int movimientos){
		/*Manejador de movimientos que se inicializa con la distancia maxima
		a la que se puede mover un algoformer.*/
		this.setMovimientosRestantes(movimientos);
		this.setMovimientosTotales(movimientos);
	}
	
	public void setMovimientosRestantes(int movimientos){
		this.movimientosRestantes = movimientos;
	}
	
	private void setMovimientosTotales(int movimientos){
		this.movimientosTotales=movimientos;
	}
	
	private void restarMovimiento(){
		this.movimientosRestantes -= UNICO;
	}
	
	public void resetearMovimientos(){
		this.movimientosRestantes = this.movimientosTotales;
	}
	
	public void moverEnDireccion(AlgoFormer algoformer, Direccion direccion, Mapa mapa){
		/*Funcion que le pide al mapa que mueva un algoformer en alguina direccion.
		 * Recibe como parametro el algoformer a mover, la direccion y el mapa.
		 * Esta funcion lanza una excepcion si el algoformer ya utilizo todos sus movimientos
		 * disponibles en un turno
		 */
		
		if(this.movimientosRestantes == NULO){
			throw new MovimientosAgotadosException();
		}
		
		mapa.moverAtacableEnDireccion(algoformer,direccion);
		this.restarMovimiento();
	}
	
	//funcion que sirve para las pruebas
	public int getMovimientosRestantes(){
		return this.movimientosRestantes;
	}

	public void actualizarMovimientos(int nuevoValor) {
		int diferencia = Math.abs(this.movimientosTotales - nuevoValor);
		this.movimientosRestantes -= diferencia;
		if (this.movimientosRestantes < 0) this.movimientosRestantes = 0;
	}
}

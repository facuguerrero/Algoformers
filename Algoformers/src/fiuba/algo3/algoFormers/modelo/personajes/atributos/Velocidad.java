package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class Velocidad extends Atributo{
	
	public Velocidad(int velocidad){
		super(velocidad);
	}
	
	//Metodo para las pruebas. No se deberian usar
	public int getVelocidad(){
		return this.valorActual();
	}

	public ManejadorDeMovimientos crearManejadorMovimientos() {
//		valorActual = this.calcularValorActual();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(this.valorActual);
		return manejador;
	}

	public void actualizarManejadorMovimiento(ManejadorDeMovimientos manejador) {
		manejador.actualizarMovimientos(this.valorActual);
	}
	
}

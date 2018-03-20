package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class DistanciaDeAtaque extends Atributo{
	
	public DistanciaDeAtaque(int distAtaque){
		super(distAtaque);
	}
	
	public ManejadorDeAtaques crearManejadorAtaques(int ataque) {
		/*Metodo que devuelve el manejador de ataque seteado con el poder
		 * de ataque y la distancia.
		 */
//		valorActual = this.calcularValorActual();
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(ataque, this.valorActual);
		return manejador;
	}
	
	//Este metodo es para las pruebas. No se deberia usar
	public int getDistanciaDeAtaque(){
		return this.valorActual;
	}
	
}

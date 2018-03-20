package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeAtaques {
	
	private int poderAtaque;
	private int distanciaAtaque;
	
	public ManejadorDeAtaques(int poder, int distancia){
		/*constructor del manejador de ataques. Este contiene la distancia de 
		 * ataque del algoformer en su modo actual y el poder de ataque*/
		
		this.setPoder(poder);
		this.setDistancia(distancia);
	}
	
	private void setPoder(int poder){
		this.poderAtaque = poder;
	}
	
	private void setDistancia(int distancia){
		this.distanciaAtaque = distancia;
	}
	
	public void atacar(AlgoFormer algoformer, Posicion posicionAtacable, Mapa mapa){
		/*Funcion atacar del manejador de ataques. esta funcion le pide al mapa
		 * que ataca a una posicion. recibe el algoformer que esta atacando por parametro
		 * la posicion a la que se ataca y el mapa.
		 */
		Posicion posicionAlgoformerAtacante = mapa.obtenerPosicion(algoformer);
		int distancia = mapa.obtenerDistancia(posicionAlgoformerAtacante, posicionAtacable);
		
		if (distancia > distanciaAtaque){
			throw new AtaqueFueraDeRangoException("Esta muy lejos para atacar!!!");
		}
		
		AlgoFormer algoformerAtacado = (AlgoFormer) mapa.getAtacable(posicionAtacable);
		this.verificarObjetivoValido(algoformerAtacado);
		algoformer.atacarEnemigo(algoformerAtacado, poderAtaque);
	}	
	
	private void verificarObjetivoValido(AlgoFormer objetivo){
		if (objetivo == null) throw new AtaqueEspacioVacioException();
	}
	
}

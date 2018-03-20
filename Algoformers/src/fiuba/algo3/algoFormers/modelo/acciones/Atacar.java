package fiuba.algo3.algoFormers.modelo.acciones;

import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Atacar implements Accion {

	private Mapa mapa;
	private AlgoFormer atacante;
	private Posicion destino;
	
	public Atacar(Mapa mapa, AlgoFormer atacante, Posicion destino){
		this.setMapa(mapa);
		this.setAtacante(atacante);
		this.setDestino(destino);
	}
	
	private void setMapa(Mapa mapa){
		this.mapa = mapa;
	}
	
	private void setAtacante(AlgoFormer atacante){
		this.atacante = atacante;
	}
	
	private void setDestino(Posicion destino){
		this.destino = destino;
	}
	
	public void ejecutar(){
		this.atacante.atacarPosicion(this.destino, this.mapa);
	}
}

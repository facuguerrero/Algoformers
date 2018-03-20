package fiuba.algo3.algoFormers.modelo.acciones;

import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;

public class Combinar implements Accion {

	private Jugador jugador;
	private Mapa mapa;
	
	public Combinar(Jugador jugador, Mapa mapa){
		this.setJugador(jugador);
		this.setMapa(mapa);
	}
	
	private void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	private void setMapa(Mapa mapa){
		this.mapa = mapa;
	}
	
	public void ejecutar() {
		this.jugador.combinar(this.mapa);
	}

}

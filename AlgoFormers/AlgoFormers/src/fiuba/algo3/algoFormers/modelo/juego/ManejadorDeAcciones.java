package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.acciones.Atacar;
import fiuba.algo3.algoFormers.modelo.acciones.Combinar;
import fiuba.algo3.algoFormers.modelo.acciones.Mover;
import fiuba.algo3.algoFormers.modelo.acciones.Transformar;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;

public class ManejadorDeAcciones {

	private Mapa mapa;
	
	public ManejadorDeAcciones(Mapa mapa){
		this.setMapa(mapa);
	}
	
	private void setMapa(Mapa mapa){
		this.mapa = mapa;
	}
	
	public void atacar(Jugador jugador, Posicion posicion){
		Accion accion = new Atacar(this.mapa, jugador.getPersonajeActual(), posicion);
		accion.ejecutar();
	}
	
	public void mover(Jugador jugador, Direccion direccion){
		Accion accion = new Mover(this.mapa, jugador.getPersonajeActual(), direccion);
		accion.ejecutar();
	}

	public void transformar(Jugador jugador) {
		Accion accion = new Transformar(jugador.getPersonajeActual());
		accion.ejecutar();
	}

	public void combinar(Jugador jugador, Mapa mapa) {
		Accion accion = new Combinar(jugador, mapa);
		accion.ejecutar();
	}
}
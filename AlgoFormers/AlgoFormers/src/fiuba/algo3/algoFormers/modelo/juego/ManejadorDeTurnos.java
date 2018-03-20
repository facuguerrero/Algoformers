package fiuba.algo3.algoFormers.modelo.juego;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeTurnos {

	private Jugador jugadorActual;
	private Jugador jugadorOpuesto;
	
	public ManejadorDeTurnos(Jugador jugadorUno, Jugador jugadorDos){
		this.seleccionarJugadorRandom(jugadorUno, jugadorDos);
	}
	
	private void seleccionarJugadorRandom(Jugador jugadorUno, Jugador jugadorDos){
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(jugadorUno);
		jugadores.add(jugadorDos);
		
		Random generador = new Random();
		int seleccion = generador.nextInt(jugadores.size());
		
		this.jugadorActual = jugadores.get(seleccion);
		if (seleccion == 1) this.jugadorOpuesto = jugadores.get(0);
		else this.jugadorOpuesto = jugadores.get(1);
	}
	
	public Jugador jugadorActual(){
		return this.jugadorActual;
	}
	public Jugador jugadorOpuesto() {
		return this.jugadorOpuesto;
	}
	
	public void finalizarTurno(Mapa mapa){
		this.jugadorActual.finalizarTurno();
		this.cambiarJugadores();
		this.jugadorActual.iniciarTurno(mapa);
	}
	
	private void cambiarJugadores(){
		Jugador jugadorAux = this.jugadorActual;
		this.jugadorActual = this.jugadorOpuesto;
		this.jugadorOpuesto = jugadorAux;
	}

	public void setPersonajeActual(AlgoFormer personaje) {
		this.jugadorActual.setPersonajeActual(personaje);
	}
	
	public ArrayList<AlgoFormer> getAlgoformersActuales() {
		ArrayList<AlgoFormer> ListaAlgoformer = new ArrayList<AlgoFormer>();
		AlgoFormer actual = this.jugadorActual.getPersonajeActual();
		Set<AlgoFormer> personajes = this.jugadorActual.getPersonajes();
		ListaAlgoformer.add(actual);
		personajes.forEach((personaje) -> {
			if(personaje.getNombre() != actual.getNombre()){
				ListaAlgoformer.add(personaje);
			}
		});
		return ListaAlgoformer;
	}	
}

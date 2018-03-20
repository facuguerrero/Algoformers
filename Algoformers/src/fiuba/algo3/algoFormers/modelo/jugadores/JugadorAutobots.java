package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.Set;

import fiuba.algo3.algoFormers.modelo.jugadores.equipos.EquipoAutoBot;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;

public class JugadorAutobots extends Jugador {

	private static int FILA_INICIO = 0;
	private EquipoAutoBot equipo;
	
	public JugadorAutobots() {
		super();
		this.inicializarEquipo();
	}
	
	public void setPersonajeActual(AlgoFormer personaje){
		this.equipo.setPersonajeActual(personaje);
	}
	
	public void combinar(Mapa mapa){
		this.equipo.combinar(mapa);
	}
	
	public void finalizarTurno(){
		this.equipo.finalizarTurno();
	}

	public AlgoFormer getPersonajeActual(){
		return this.equipo.personajeActual();
	}
	
	public void iniciarTurno(Mapa mapa){
		this.equipo.iniciarTurno(mapa);
	}
	
	@Override
	public void inicializarEquipo() {
		AutoBot optimus = (AutoBot) this.fabrica.getOptimusPrime();
		AutoBot bumblebee = (AutoBot) this.fabrica.getBumblebee();
		AutoBot ratchet = (AutoBot) this.fabrica.getRatchet();
		this.equipo = new EquipoAutoBot(optimus, bumblebee, ratchet);
	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		this.equipo.ubicarPersonajes(mapa, FILA_INICIO);
	}

	@Override
	public AutoBot getAlgoformer(String nombre) {
		AutoBot personaje = (AutoBot) this.equipo.getAlgoFormer(nombre);
		return personaje;
	}

	@Override
	public Set<AlgoFormer> getPersonajes() {
		return this.equipo.getPersonajes();
	}

}

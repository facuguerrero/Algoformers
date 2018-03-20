package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.Set;

import fiuba.algo3.algoFormers.modelo.jugadores.equipos.EquipoDecepticon;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadorDecepticons extends Jugador {

	private static int FILA_INICIO = 2;
	private EquipoDecepticon equipo;
	
	public JugadorDecepticons() {
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
		Decepticon megatron = (Decepticon) this.fabrica.getMegatron();
		Decepticon bonecrusher = (Decepticon) this.fabrica.getBonecrusher();
		Decepticon frenzy = (Decepticon) this.fabrica.getFrenzy();
		this.equipo = new EquipoDecepticon(megatron, bonecrusher, frenzy);
	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		this.equipo.ubicarPersonajes(mapa, FILA_INICIO);
	}

	@Override
	public Decepticon getAlgoformer(String nombre) {
		Decepticon personaje = (Decepticon) this.equipo.getAlgoFormer(nombre);
		return personaje;
	}
	
	@Override
	public Set<AlgoFormer> getPersonajes() {
		return this.equipo.getPersonajes();
	}

}
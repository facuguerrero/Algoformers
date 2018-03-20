package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.Set;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;


public abstract class Jugador {
	
	protected AlgoFormerFactory fabrica;
	protected String nombre;
	
	public Jugador(){
		this.fabrica = new AlgoFormerFactory();
	}
	
	/**
	 * Define como personaje actual al recibido.
	 */
	public abstract void setPersonajeActual(AlgoFormer personaje);
	
	/**
	 * Combina a sus personajes en un MegaBot
	 */
	public abstract void combinar(Mapa mapa);
	
	/**
	 * Finaliza el turno de todos los personajes de un jugador.
	 */
	public abstract void finalizarTurno();
	
	/**
	 * Inicia un turno verificando si los personajes estan vivos o muertos para permanecer
	 * o no en el juego.
	 */
	public abstract void iniciarTurno(Mapa mapa);
	
	/**
	 * Devuelve el personaje que esta actualmente seleccionado
	 */
	public abstract AlgoFormer getPersonajeActual();
	
	/**
	 * Inicializa los algoformers del jugador segun el tipo del jugador del
	 * que se trate
	 */
	public abstract void inicializarEquipo();
	
	/**
	 * Ubica los personajes en las posiciones iniciales del mapa,
	 * enfrentados entre si.
	 * @param mapa :Mapa en estado valido
	 */
	public abstract void ubicarPersonajes(Mapa mapa);

	/**
	 * @param nombre :Nombre del algoformer que se quiere obtener. Debe ser alguno
	 * de los prefijados en la Fabrica de personajes
	 * @return Algoformer de nombre coincidente con el recibido.
	 */
	public abstract AlgoFormer getAlgoformer(String nombre);
	
	public void guardarNombre(String nombre){
		this.nombre = nombre;
	}

	public abstract Set<AlgoFormer> getPersonajes();

	public String getNombre() {
		return this.nombre;
	}

	//public abstract Set<String> getPersonajes();
}

package fiuba.algo3.algoFormers.modelo.jugadores.equipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.excepciones.EquipoDestruidoException;
import fiuba.algo3.algoFormers.modelo.excepciones.EquipoNoCompletoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDeRangoParaCombinarException;
import fiuba.algo3.algoFormers.modelo.excepciones.SeleccionPersonajeEnemigoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Equipo {

	protected HashMap<String, AlgoFormer> equipo;
	protected AlgoFormer personajeActual;
	protected AlgoFormer anteriorACombinar;
	protected int turnosCombinacion = 0;
	protected boolean combinado = false;
	
	public Equipo(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.setEquipo(uno, dos, tres);
	}
	
	private void setEquipo(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.equipo = new HashMap<String, AlgoFormer>();
		this.agregarIntegrante(uno);
		this.agregarIntegrante(dos);
		this.agregarIntegrante(tres);
	}
	
	public void agregarIntegrante(AlgoFormer personaje){
		this.equipo.put(personaje.getNombre(), personaje);
		this.setPersonajeActual(personaje);
		this.anteriorACombinar = personaje;
	}
	
	public void finalizarTurno(){
		this.equipo.forEach( (nombre, personaje) -> personaje.finalizarTurno() );
		this.checkCombinacion();
	}
	
	private void checkCombinacion(){
		if (this.turnosCombinacion > 0){
			this.turnosCombinacion--;
			this.finalizarTurnoMegaBot();
		}
	}
	
	protected abstract void finalizarTurnoMegaBot();
	
	public void iniciarTurno(Mapa mapa){

		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		ArrayList<AlgoFormer> personajes = new ArrayList<AlgoFormer>();
		while (iter.hasNext()) {
			String nombre = iter.next();
			AlgoFormer algoformer = this.equipo.get(nombre);
			personajes.add(algoformer);
		}
		int tam = personajes.size();
		for (int i = 0; i < tam; i++){
			AlgoFormer personaje = personajes.get(i);
			this.checkPermanenciaEnJuego(personaje, mapa);
		}
		if (this.todosMuertos()) throw new EquipoDestruidoException();
		if ((this.turnosCombinacion == 0 || this.equipoIncompleto()) && this.combinado) this.finalizarCombinacion(mapa);
		
	}
	
	private boolean equipoIncompleto(){
		return this.equipo.size() < 3;
	}
	
	private boolean todosMuertos(){
		return this.equipo.size() == 0;
	}
	
	public void setPersonajeActual(AlgoFormer personaje){
		AlgoFormer almacenado = this.equipo.get(personaje.getNombre());
		if (almacenado == null) throw new SeleccionPersonajeEnemigoException();
		this.personajeActual = almacenado;
	}
	
	public AlgoFormer personajeActual(){
		return this.personajeActual;
	}
	
	public void combinar(Mapa mapa){
		this.verificarCondicionesCombinacion(mapa);
		this.anteriorACombinar = this.personajeActual;
		Posicion posUnion = mapa.obtenerPosicion(this.personajeActual);
		this.sacarIntegrantesDelMapa(mapa);
		this.definirMegaBotComoActual(this.calcularVidaMegaBot());
		this.ubicarMegabot(mapa, posUnion);
		this.turnosCombinacion = 3;
		this.combinado = true;
	}
	
	protected abstract void ubicarMegabot(Mapa mapa, Posicion posUnion);
	
	protected abstract void definirMegaBotComoActual(int vida);
	
	private void sacarIntegrantesDelMapa(Mapa mapa){
		this.equipo.forEach((nombre, personaje) -> mapa.borrarPersonaje(personaje));
	}
	
	private void finalizarCombinacion(Mapa mapa){
		this.reubicarPersonajes(mapa);
		this.turnosCombinacion = 0;
		this.personajeActual = this.anteriorACombinar;
		this.combinado = false;
	}
	
	protected abstract void reubicarPersonajes(Mapa mapa);
	
	protected void ubicarIntegrantesEnAlrededores(Posicion posicionMegaBot, Mapa mapa){
		this.equipo.forEach( (nombre, personaje) ->	mapa.ubicarEnAlrededores(personaje, posicionMegaBot));
	}
	
	protected int calcularVidaMegaBot(){
		int total = 0;
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		while (iter.hasNext()) {
			String nombre = iter.next();
			AlgoFormer algoformer = this.equipo.get(nombre);
			total += algoformer.getVida();
		}
		return total;
	}
	
	public void ubicarPersonajes(Mapa mapa, int filaInicio) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 2;
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		while (iter.hasNext()) {
			String nombre = iter.next();
			AlgoFormer algoformer = this.equipo.get(nombre);
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}
	}
	
	public AlgoFormer getAlgoFormer(String nombre){
		Set<String> nombres = this.equipo.keySet();
		Iterator<String> iter = nombres.iterator();
		while (iter.hasNext()) {
			String nombreGuardado = iter.next();
			if (nombreGuardado == nombre) {				
				return this.equipo.get(nombreGuardado);
			}			
		}
		return null;
	}
	
	private void verificarCondicionesCombinacion(Mapa mapa){
		this.verificarDistanciaCombinacion(mapa);
		this.verificarCantidadDePersonajes();
	}
	
	private void verificarCantidadDePersonajes(){
		if (this.equipo.size() < 3) throw new EquipoNoCompletoException();
	}
	
	public void checkPermanenciaEnJuego(AlgoFormer personaje, Mapa mapa){
		if (personaje.muerto()){
			mapa.borrarPersonaje(personaje);
			this.equipo.remove(personaje.getNombre());
		}
	}
	
	private void verificarDistanciaCombinacion(Mapa mapa){
		this.equipo.forEach((nombre, personaje) -> this.equipo.forEach( (nombre2, personaje2) -> {
			this.verificarDistanciaCombinacionEntre(personaje, personaje2, mapa);
		}));
	}
	
	private void verificarDistanciaCombinacionEntre(AlgoFormer uno, AlgoFormer otro, Mapa mapa){
		Posicion posicionUno = mapa.obtenerPosicion(uno);
		Posicion posicionOtro = mapa.obtenerPosicion(otro);
		int distancia = mapa.obtenerDistancia(posicionUno, posicionOtro);
		if (distancia > 2) throw new FueraDeRangoParaCombinarException();
	}
}

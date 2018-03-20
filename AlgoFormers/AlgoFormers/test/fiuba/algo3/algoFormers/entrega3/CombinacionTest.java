package fiuba.algo3.algoFormers.entrega3;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.acciones.Combinar;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;

public class CombinacionTest {
	
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorAutobotsRemueveAOptimus() {
		
		JugadorAutobots jug = new JugadorAutobots();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posOptimus = new Posicion(0,19);
		
		assertEquals(map.getAtacable(posOptimus), jug.getAlgoformer("Optimus Prime"));		
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		
		map.obtenerPosicion(jug.getAlgoformer("Optimus Prime"));
	}
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorAutobotsRemueveABumblebee() {
		
		JugadorAutobots jug = new JugadorAutobots();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posBumblebee = new Posicion(0,18);
						
		assertEquals(map.getAtacable(posBumblebee), jug.getAlgoformer("Bumblebee"));	
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		
		map.obtenerPosicion(jug.getAlgoformer("Ratchet"));
	}
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorAutobotsRemueveARatchet() {
		
		JugadorAutobots jug = new JugadorAutobots();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posRatchet = new Posicion(0,20);
		
		assertEquals(map.getAtacable(posRatchet), jug.getAlgoformer("Ratchet"));
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		
		map.obtenerPosicion(jug.getAlgoformer("Optimus Prime"));
	}
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorDecepticonsRemueveAMegatron() {
		
		JugadorDecepticons jug = new JugadorDecepticons();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posMegatron = new Posicion(39,20);
		
		assertEquals(map.getAtacable(posMegatron), jug.getAlgoformer("Megatron"));		
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		//
		map.obtenerPosicion(jug.getAlgoformer("Megatron"));
	}
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorDecepticonsRemueveABonecrusher() {
		
		JugadorDecepticons jug = new JugadorDecepticons();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posBonecrusher = new Posicion(39,18);
		
		assertEquals(map.getAtacable(posBonecrusher), jug.getAlgoformer("Bonecrusher"));		
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		
		map.obtenerPosicion(jug.getAlgoformer("Bonecrusher"));
	}
	
	@Test(expected=UbicableNoPertenceAlMapaException.class)
	public void testCombinacionJugadorDecepticonsRemueveAFrenzy() {
		
		JugadorDecepticons jug = new JugadorDecepticons();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posFrenzy = new Posicion(39,19);
		
		assertEquals(map.getAtacable(posFrenzy), jug.getAlgoformer("Frenzy"));		
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
		map.obtenerPosicion(jug.getAlgoformer("Frenzy"));
		
	}
	
	@Test
	public void testCombinacionJugadorAutobotsCreaMegabot() {
		
		JugadorAutobots jug = new JugadorAutobots();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posComb = map.obtenerPosicion(jug.getPersonajeActual());
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();		
		assertNotEquals(posComb, null);
	}
	
	
}

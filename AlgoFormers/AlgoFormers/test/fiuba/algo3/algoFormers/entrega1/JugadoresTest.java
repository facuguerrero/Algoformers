package fiuba.algo3.algoFormers.entrega1;
import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadoresTest {
	
	
	@Test
	public void crearJugadorAutobotsInicializaCorrectamenteASusAutobots() {
		
		JugadorAutobots jug = new JugadorAutobots();
		jug.inicializarEquipo();
		
		AutoBotFactory fabrica = new AutoBotFactory();
		AutoBot optimus = fabrica.getOptimusPrime();
		AutoBot bumb = fabrica.getBumblebee();
		AutoBot rat = fabrica.getRatchet();
		
		assertEquals(optimus, jug.getAlgoformer("Optimus Prime"));
		assertEquals(bumb, jug.getAlgoformer("Bumblebee"));
		assertEquals(rat, jug.getAlgoformer("Ratchet"));
		
	}
	
	@Test
	public void crearJugadorDecepticonsInicializaCorrectamenteASusDecepticons() {
		
		JugadorDecepticons jug = new JugadorDecepticons();
		jug.inicializarEquipo();
		
		DecepticonFactory fabrica = new DecepticonFactory();
		Decepticon optimus = fabrica.getMegatron();
		Decepticon bumb = fabrica.getBonecrusher();
		Decepticon rat = fabrica.getFrenzy();
		
		assertEquals(optimus, jug.getAlgoformer("Megatron"));
		assertEquals(bumb, jug.getAlgoformer("Bonecrusher"));
		assertEquals(rat, jug.getAlgoformer("Frenzy"));
		
	}
	
	@Test
	public void JugadorAutobotsUbicaCorrectamenteASusAutobots() {
		
		Mapa mapa = new Mapa();
		JugadorAutobots jug = new JugadorAutobots();
		jug.inicializarEquipo();

		Posicion pos1 = new Posicion(0, 18);
		Posicion pos2 = new Posicion(0, 19);
		Posicion pos3 = new Posicion(0, 20);
		
		jug.ubicarPersonajes(mapa);
		
		assertEquals(AutoBot.class, mapa.getAtacable(pos1).getClass());
		assertEquals(AutoBot.class, mapa.getAtacable(pos2).getClass());
		assertEquals(AutoBot.class, mapa.getAtacable(pos3).getClass());		
	}
	
	@Test
	public void JugadorDecepticonsUbicaCorrectamenteASusDecepticons() {
		
		Mapa mapa = new Mapa();
		JugadorDecepticons jug = new JugadorDecepticons();
		jug.inicializarEquipo();
		
		Posicion pos1 = new Posicion(39, 18);
		Posicion pos2 = new Posicion(39, 19);
		Posicion pos3 = new Posicion(39, 20);
		
		jug.ubicarPersonajes(mapa);
		
		assertEquals(Decepticon.class, mapa.getAtacable(pos1).getClass());
		assertEquals(Decepticon.class, mapa.getAtacable(pos2).getClass());
		assertEquals(Decepticon.class, mapa.getAtacable(pos3).getClass());
	}
}

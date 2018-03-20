package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.mapa.Casillero;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;


public class MapaTest {

	private Mapa mapa;
	private AlgoFormer megatron;
	private AlgoFormer optimusPrime;
	private Posicion posicion1;
	private AlgoFormer bumblebee;
	private AlgoFormer frenzy;

	@Before
	public void setUp(){
		AlgoFormerFactory factoryA = new AlgoFormerFactory();
		optimusPrime = factoryA.getOptimusPrime();
		bumblebee = factoryA.getBumblebee();
		megatron = factoryA.getMegatron();
		frenzy = factoryA.getFrenzy();
		mapa = new Mapa();
		posicion1 = new Posicion(3,4); 
	}

	@Test
	public void testCrearUnMapa() {
		assertNotNull(mapa);
	}
	
	@Test
	public void testCrearUnMapaDeTamanioCorrectoLlenoDeCasilleros() {
		int tamanio = mapa.getTamanio();
		for(int i = 0; i < tamanio; i++){
			for(int j = 0; j < tamanio; j++){
				assertEquals(mapa.getCasillero(new Posicion(i,j)).getClass(), Casillero.class);
			}
		}
	}
	
	@Test
	public void testUbicarExitosamenteAUnAutobot(){
		mapa.ubicar(optimusPrime, posicion1);
		assertEquals(mapa.getAtacable(posicion1), optimusPrime);
	}
	
	@Test
	public void testUbicarExitosamenteAUnDecepticon(){
		mapa.ubicar(megatron, posicion1);
		assertEquals(mapa.getAtacable(posicion1), megatron);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testFallaUbicarAUnAutobot(){
		mapa.ubicar(optimusPrime, posicion1);
		mapa.ubicar(bumblebee, posicion1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testFallaUbicarAUnDecepticon(){
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(frenzy, posicion1);
	}	

	@Test
	public void testMoverAUnAutobotUnaVezExitosamente(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		mapa.moverAtacableEnDireccion(optimusPrime, new DirAbajoDer());
		Posicion nuevaPosicion = new Posicion (3,9);
		
		assertEquals(mapa.getAtacable(nuevaPosicion).getClass(), optimusPrime.getClass());
		//En la posicion vieja no esta mas optimus
		assertNull(mapa.getAtacable(posicion));
	}
	
	@Test
	public void testMoverAUnDecepticonUnaVezExitosamente(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(megatron, posicion);
		mapa.moverAtacableEnDireccion(megatron, new DirArribaDer());
		Posicion nuevaPosicion = new Posicion (3,7);
		
		assertEquals(mapa.getAtacable(nuevaPosicion).getClass(), megatron.getClass());
		//En la posicion vieja no esta mas megatron
		assertNull(mapa.getAtacable(posicion));
	}	
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testMoverAUnAutobotUnaVezADondeHabiaOtroAutobotFalla(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		
		Posicion nuevaPosicion = new Posicion (2,7);
		mapa.ubicar(bumblebee, nuevaPosicion);
		
		mapa.moverAtacableEnDireccion(optimusPrime, new DirArriba());
	}	

	@Test(expected = CasilleroOcupadoException.class)
	public void testMoverAUnAutobotUnaVezADondeHabiaOtroDecepticonFalla(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		
		Posicion nuevaPosicion = new Posicion (2,7);
		mapa.ubicar(megatron, nuevaPosicion);
		
		mapa.moverAtacableEnDireccion(optimusPrime, new DirArriba());
	}
	
	@Test(expected = UbicableNoPertenceAlMapaException.class)
	public void testMoverAUnAutobotQueNoEstaUbicadoFalla(){
		mapa.moverAtacableEnDireccion(optimusPrime, new DirArriba());
	}
	
	@Test(expected = UbicableNoPertenceAlMapaException.class)
	public void testMoverAUnDecepticonQueNoEstaUbicadoFalla(){
		mapa.moverAtacableEnDireccion(megatron, new DirAbajo());
	}
	
}

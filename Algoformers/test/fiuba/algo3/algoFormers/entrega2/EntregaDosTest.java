package fiuba.algo3.algoFormers.entrega2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.superficies.SuperficiesFactory;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algoFormers.modelo.excepciones.HumanoideNoPuedeAtravesarException;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;

public class EntregaDosTest {

	private Mapa mapa;
	private AlgoFormerFactory factoryA;
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	private AlgoFormer bumblebee;
	private AlgoFormer megatron;
	private AlgoFormer frenzy;
	private AlgoFormer bonecrusher;
	private SuperficiesFactory factoryS;
	
	@Before
	public void setUp(){
		mapa = new Mapa();
		factoryA = new AlgoFormerFactory();
		optimus = factoryA.getOptimusPrime();
		ratchet = factoryA.getRatchet();
		bumblebee = factoryA.getBumblebee();
		megatron = factoryA.getMegatron();
		frenzy = factoryA.getFrenzy();
		bonecrusher = factoryA.getBonecrusher();
		factoryS= new SuperficiesFactory();
	}

	@Test
	public void testOptimusHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(optimus, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus.getVida(), 500);
		assertEquals(optimus.getAtaque(), 50);
		assertEquals(optimus.getDistanciaDeAtaque(), 2);
		assertEquals(optimus.getVelocidad(), 2);		
	}
	
	@Test
	public void testRatchetHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 150);
		assertEquals(ratchet.getAtaque(), 5);
		assertEquals(ratchet.getDistanciaDeAtaque(), 5);
		assertEquals(ratchet.getVelocidad(), 1);		
	}
	
	@Test
	public void testBumblebeeHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bumblebee, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertEquals(bumblebee.getVida(), 350);
		assertEquals(bumblebee.getAtaque(), 40);
		assertEquals(bumblebee.getDistanciaDeAtaque(), 1);
		assertEquals(bumblebee.getVelocidad(), 2);		
	}
	
	@Test
	public void testMegatronHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 550);
		assertEquals(megatron.getAtaque(), 10);
		assertEquals(megatron.getDistanciaDeAtaque(), 3);
		assertEquals(megatron.getVelocidad(), 1);		
	}
	
	@Test
	public void testFrenzyHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(frenzy, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertEquals(frenzy.getVida(), 400);
		assertEquals(frenzy.getAtaque(), 10);
		assertEquals(frenzy.getDistanciaDeAtaque(), 5);
		assertEquals(frenzy.getVelocidad(), 2);		
	}
	
	@Test
	public void testBonecrusherHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bonecrusher, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertEquals(bonecrusher.getVida(), 200);
		assertEquals(bonecrusher.getAtaque(), 30);
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
		assertEquals(bonecrusher.getVelocidad(), 1);		
	}
	
	@Test
	public void testOptimusAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(optimus, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.transformarse();
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus.getVida(), 500);
		assertEquals(optimus.getAtaque(), 15);
		assertEquals(optimus.getDistanciaDeAtaque(), 4);
		assertEquals(optimus.getVelocidad(), 5);
	}
	
	@Test
	public void testRatchetAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 150);
		assertEquals(ratchet.getAtaque(), 35);
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
		assertEquals(ratchet.getVelocidad(), 8);		
	}
	
	@Test
	public void testBumblebeeAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bumblebee, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bumblebee.transformarse();
		bumblebee.moverEnDireccion(direccion, mapa);
		assertEquals(bumblebee.getVida(), 350);
		assertEquals(bumblebee.getAtaque(), 20);
		assertEquals(bumblebee.getDistanciaDeAtaque(), 3);
		assertEquals(bumblebee.getVelocidad(), 5);		
	}
	
	@Test
	public void testMegatronAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 550);
		assertEquals(megatron.getAtaque(), 55);
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
		assertEquals(megatron.getVelocidad(), 8);		
	}
	
	@Test
	public void testFrenzyAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(frenzy, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		frenzy.transformarse();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertEquals(frenzy.getVida(), 400);
		assertEquals(frenzy.getAtaque(), 25);
		assertEquals(frenzy.getDistanciaDeAtaque(), 2);
		assertEquals(frenzy.getVelocidad(), 6);		
	}
	
	@Test
	public void testBonecrusherAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bonecrusher, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.transformarse();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertEquals(bonecrusher.getVida(), 200);
		assertEquals(bonecrusher.getAtaque(), 30);
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
		assertEquals(bonecrusher.getVelocidad(), 8);		
	}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testOptimusHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(optimus, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		optimus.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testBumblebeeHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bumblebee, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		bumblebee.moverEnDireccion(direccion, mapa);	
		}

	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testRatchetHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		ratchet.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testMegatronHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		megatron.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testFrenzyHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(frenzy, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		frenzy.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testBonecrusherHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bonecrusher, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		}
	
	@Test
	public void testOptimusAlternoAtraviesaZonaPantanoConLaMitadDeVelocidad(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		Posicion posicion4 = new Posicion(1,4);
		mapa.ubicar(optimus, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		mapa.ubicar(superficie, posicion4);
		DirAbajo direccion = new DirAbajo();
		optimus.transformarse();
		for(int x=0; x<=3; x++){
			optimus.moverEnDireccion(direccion, mapa);	
		}
	}
	
	@Test
	public void testRatchetAlternoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 150);
		assertEquals(ratchet.getAtaque(), 35);
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
		assertEquals(ratchet.getVelocidad(), 8);
	}
	
	@Test
	public void testMegatronAlternoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 550);
		assertEquals(megatron.getAtaque(), 55);
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
		assertEquals(megatron.getVelocidad(), 8);		
	}
	
	@Test
	public void testOptimusHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicar(optimus, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		DirAbajo direccion = new DirAbajo();
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus.getVida(), 475);
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus.getVida(), 452);
	}
	
	@Test
	public void testRatchetHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 143);		
	}
	
	@Test
	public void testBumblebeeHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicar(bumblebee, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		DirAbajo direccion = new DirAbajo();
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertEquals(bumblebee.getVida(), 333);
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertEquals(bumblebee.getVida(), 317);
	
	}
	
	@Test
	public void testMegatronHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 523);
	}
	
	@Test
	public void testFrenzyHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicar(frenzy, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		DirAbajo direccion = new DirAbajo();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertEquals(frenzy.getVida(), 380);
		frenzy.moverEnDireccion(direccion, mapa);	
		assertEquals(frenzy.getVida(), 361);
	}
	
	@Test
	public void testBonecrusherHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(bonecrusher, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertEquals(bonecrusher.getVida(), 190);		
	}
	
	@Test
	public void testRatchetAlternoAtraviesaZonaEspinas(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 150);
		assertEquals(ratchet.getAtaque(), 35);
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
		assertEquals(ratchet.getVelocidad(), 8);
	}
	
	@Test
	public void testMegatronAlternoAtraviesaZonaEspinas(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 550);
		assertEquals(megatron.getAtaque(), 55);
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
		assertEquals(megatron.getVelocidad(), 8);		
	}
	
	@Test
	public void testRatchetAlternoAtraviesaZonaNube(){
		SuperficieAerea superficie = factoryS.getNube();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 150);
		assertEquals(ratchet.getAtaque(), 35);
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
		assertEquals(ratchet.getVelocidad(), 8);
	}
	
	@Test
	public void testMegatronAlternoAtraviesaZonaNube(){
		SuperficieAerea superficie = factoryS.getNube();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getVida(), 550);
		assertEquals(megatron.getAtaque(), 55);
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
		assertEquals(megatron.getVelocidad(), 8);		
	}
	
	@Test
	public void testRatchetAlternoAtrapadoEnLaNebulosaDeAndromeda(){
		SuperficieAerea superficie = factoryS.getNebulosaAndromeda();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);
		for(int i = 0; i < 3; i++){
			try {
				ratchet.moverEnDireccion(direccion, mapa);
			} catch (MovimientosAgotadosException e) {
				assertEquals(mapa.getAtacable(posicion2).getClass(), ratchet.getClass());
			}
			ratchet.finalizarTurno();
		}
		ratchet.moverEnDireccion(direccion, mapa);
		assertEquals(mapa.getAtacable(posicion3).getClass(), ratchet.getClass());
	}
	
	@Test
	public void testMegatronAlternoAtrapadoEnLaNebulosaDeAndromeda(){
		SuperficieAerea superficie = factoryS.getNebulosaAndromeda();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);
		for(int i = 0; i < 3; i++){
			try {
				megatron.moverEnDireccion(direccion, mapa);
			} catch (MovimientosAgotadosException e){
				
				assertEquals(mapa.getAtacable(posicion2).getClass(), megatron.getClass());
			}
			megatron.finalizarTurno();
		}
		megatron.moverEnDireccion(direccion, mapa);
		assertEquals(mapa.getAtacable(posicion3).getClass(), megatron.getClass());
	}
	
	@Test
	public void testMegatronAlternoAtraviesaTormentaPsionicaYSeDania(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		megatron.transformarse();
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getAtaque(), 33);		
	}
	
	@Test
	public void testRatchetAlternoAtraviesaTormentaPsionicaYSeDania(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		ratchet.transformarse();
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		DirAbajo direccion = new DirAbajo();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getAtaque(), 21);		
	}
	
	@Test
	public void testMegatronAlternoAtraviesaTormentaPsionicaDosVecesYSeDaniaUna(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		megatron.transformarse();
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		DirAbajo direccion = new DirAbajo();
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getAtaque(), 33);
		megatron.moverEnDireccion(direccion, mapa);	
		assertEquals(megatron.getAtaque(), 33);
	}
	
	@Test
	public void testRatchetAlternoAtraviesaTormentaPsionicaDosVecesYSeDaniaUna(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		ratchet.transformarse();
		mapa.ubicar(ratchet, posicion1);
		mapa.ubicar(superficie, posicion2);
		mapa.ubicar(superficie, posicion3);
		DirAbajo direccion = new DirAbajo();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getAtaque(), 21);
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getAtaque(), 21);
	}
	
	@Test
	public void testGetSuperficieTerrestre(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficie, posicion);
		assertEquals(mapa.getSuperficieTerrestre(posicion), superficie);
	}
	
	@Test
	public void testGetSuperficieAerea(){
		SuperficieAerea superficie = factoryS.getNube();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficie, posicion);
		assertEquals(mapa.getSuperficieAerea(posicion), superficie);
	}
	
	@Test
	public void testGetSuperficieTerrestreSinSuperficie(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficie, posicion);
		assertEquals(mapa.getSuperficieAerea(posicion), null);
	}
	
	@Test
	public void testGetSuperficieAereaSinSuperficie(){
		SuperficieAerea superficie = factoryS.getNube();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficie, posicion);
		assertEquals(mapa.getSuperficieTerrestre(posicion), null);
	}
	
	@Test
	public void testGetSuperficieTerrestreConAerea(){
		SuperficieAerea superficieA = factoryS.getNube();
		SuperficieTerrestre superficieT = factoryS.getPantano();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficieA, posicion);
		mapa.ubicar(superficieT, posicion);
		assertEquals(mapa.getSuperficieTerrestre(posicion), superficieT);
	}
	
	@Test
	public void testGetSuperficieAereaConTerrestre(){
		SuperficieAerea superficieA = factoryS.getNube();	
		SuperficieTerrestre superficieT = factoryS.getPantano();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(superficieA, posicion);
		mapa.ubicar(superficieT, posicion);
		assertEquals(mapa.getSuperficieAerea(posicion), superficieA);
	}
	
	@Test(expected=FinDelJuegoException.class)
	public void testEntrarEnCasilleroConChispaFinalizaJuego(){
		Juego juego = new Juego();
		Posicion posChispa = juego.getPosicionChispa();
		AlgoFormer optimus = (new AlgoFormerFactory()).getOptimusPrime();
		Mapa mapa = juego.getMapa();
		mapa.ubicar(optimus, posChispa);
	}
}

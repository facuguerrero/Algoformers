package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoAlternoEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getVelocidad(), 5);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getVelocidad(), 5);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getVelocidad(), 8);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getVelocidad(), 8);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getVelocidad(), 6);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getVelocidad(), 8);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getAtaque(), 15);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getAtaque(), 20);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getAtaque(), 35);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getAtaque(), 55);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getAtaque(), 25);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getAtaque(), 30);
	}
	
	//Tests de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getDistanciaDeAtaque(), 4);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
	}
}

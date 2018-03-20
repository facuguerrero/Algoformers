package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoHumanoideEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getVelocidad(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getVelocidad(), 2);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getVelocidad(), 1);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getVelocidad(), 1);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getVelocidad(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getVelocidad(), 1);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getAtaque(), 50);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getAtaque(), 40);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getAtaque(), 10);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getAtaque(), 10);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getAtaque(), 30);
	}
	
	//Test de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getDistanciaDeAtaque(), 1);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
	}
}

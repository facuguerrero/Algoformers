package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEnCreacionTest {

	//Tests de vida
	@Test
	public void testOptimusPrimeSeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getVida(), 500);
	}
	
	@Test
	public void testBumblebeeSeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getVida(), 350);
	}
	
	@Test
	public void testRatchetSeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getVida(), 150);
	}
	
	@Test
	public void testMegatronSeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getVida(), 550);
	}
	
	@Test
	public void testFrenzySeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getVida(), 400);
	}
	
	@Test
	public void testBonecrusherSeCreaConVidaCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getVida(), 200);
	}
	
	//Tests de nombre
	@Test
	public void testOptimusPrimeSeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getNombre(), "Optimus Prime");
	}
	
	@Test
	public void testBumblebeeSeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getNombre(), "Bumblebee");
	}
	
	@Test
	public void testRatchetSeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getNombre(), "Ratchet");
	}
	
	@Test
	public void testMegatronSeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getNombre(), "Megatron");
	}
	
	@Test
	public void testFrenzySeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getNombre(), "Frenzy");
	}
	
	@Test
	public void testBonecrusherSeCreaConNombreCorrecta(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getNombre(), "Bonecrusher");
	}
}

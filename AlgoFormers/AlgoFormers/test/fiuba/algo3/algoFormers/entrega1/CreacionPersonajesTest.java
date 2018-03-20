package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class CreacionPersonajesTest {

	//Tests de creacion de fabricas
	@Test
	public void testCrearFabricaDeAlgoFormers(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		assertNotNull(factory);
	}
	
	@Test
	public void testCrearFabricaDeAutoBots(){
		AutoBotFactory factory = new AutoBotFactory();
		assertNotNull(factory);
	}
	
	@Test
	public void testCrearFabricaDeDecepticons(){
		DecepticonFactory factory = new DecepticonFactory();
		assertNotNull(factory);
	}
	
	//Tests de creacion de AlgoFormers	
	@Test
	public void testCrearOptimusPrime(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertNotNull(optimusPrime);
	}
	
	@Test
	public void testCrearBumblebee(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertNotNull(bumblebee);
	}
	
	@Test
	public void testCrearRatchet(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertNotNull(ratchet);
	}
	
	@Test
	public void testCrearMegatron(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertNotNull(megatron);
	}
	
	@Test
	public void testCrearFrenzy(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertNotNull(frenzy);
	}
	
	@Test
	public void testCrearBonecrusher(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertNotNull(bonecrusher);
	}
}

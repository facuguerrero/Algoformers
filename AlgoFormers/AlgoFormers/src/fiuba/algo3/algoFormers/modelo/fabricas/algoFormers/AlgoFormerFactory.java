package fiuba.algo3.algoFormers.modelo.fabricas.algoFormers;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AlgoFormerFactory {

	private AutoBotFactory autoBot;
	private DecepticonFactory decepticon;
	
	public AlgoFormerFactory(){
		this.setAutoBotFactory();
		this.setDecepticonFactory();
	}
	
	private void setAutoBotFactory(){
		this.autoBot = new AutoBotFactory();
	}
	
	private void setDecepticonFactory(){
		this.decepticon = new DecepticonFactory();
	}
	
	public AlgoFormer getOptimusPrime(){
		return this.autoBot.getOptimusPrime();
	}
	
	public AlgoFormer getBumblebee(){
		return this.autoBot.getBumblebee();
	}
	
	public AlgoFormer getRatchet(){
		return this.autoBot.getRatchet();
	}
	
	public AlgoFormer getMegatron(){
		return this.decepticon.getMegatron();
	}
	
	public AlgoFormer getFrenzy(){
		return this.decepticon.getFrenzy();
	}
	
	public AlgoFormer getBonecrusher(){
		return this.decepticon.getBonecrusher();
	}
	
	
}

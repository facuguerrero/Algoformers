package fiuba.algo3.algoFormers.modelo.fabricas.algoFormers;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;

public class AutoBotFactory {	
	
	public AutoBotFactory(){
		
	}
	
	public AutoBot getOptimusPrime(){
		Alterno peterbilt379 = new AlternoTerrestre(EAF.OPTIMUS.velA(), EAF.OPTIMUS.atA(), EAF.OPTIMUS.dAtA());
		return this.crearAutoBot(EAF.OPTIMUS.nombre() , EAF.OPTIMUS.vida(), peterbilt379, EAF.OPTIMUS.velH(), EAF.OPTIMUS.atH(), EAF.OPTIMUS.dAtH());
	}
	
	public AutoBot getBumblebee(){
		Alterno camaro = new AlternoTerrestre(EAF.BUMBLEBEE.velA(), EAF.BUMBLEBEE.atA(), EAF.BUMBLEBEE.dAtA());
		return this.crearAutoBot(EAF.BUMBLEBEE.nombre() , EAF.BUMBLEBEE.vida(), camaro, EAF.BUMBLEBEE.velH(), EAF.BUMBLEBEE.atH(), EAF.BUMBLEBEE.dAtH());
	}
	
	public AutoBot getRatchet(){
		Alterno f22raptor = new AlternoAereo(EAF.RATCHET.velA(), EAF.RATCHET.atA(), EAF.RATCHET.dAtA());
		return this.crearAutoBot(EAF.RATCHET.nombre() , EAF.RATCHET.vida(), f22raptor, EAF.RATCHET.velH(), EAF.RATCHET.atH(), EAF.RATCHET.dAtH());
	}
	
	/**
	 * Crea un AutoBot con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private AutoBot crearAutoBot(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		return new AutoBot(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
}

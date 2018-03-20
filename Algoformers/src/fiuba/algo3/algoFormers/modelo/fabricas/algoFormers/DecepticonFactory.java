package fiuba.algo3.algoFormers.modelo.fabricas.algoFormers;

import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;

public class DecepticonFactory {
	
	public DecepticonFactory(){

	}
	
	public Decepticon getMegatron(){
		Alterno jetCibertroniano = new AlternoAereo(EAF.MEGATRON.velA(), EAF.MEGATRON.atA(), EAF.MEGATRON.dAtA());
		return this.crearDecepticon(EAF.MEGATRON.nombre(), EAF.MEGATRON.vida(), jetCibertroniano, EAF.MEGATRON.velH(), EAF.MEGATRON.atH(), EAF.MEGATRON.dAtH());
	}
	
	public Decepticon getFrenzy(){
		Alterno buffaloHMPCV = new AlternoTerrestre(EAF.FRENZY.velA(), EAF.FRENZY.atA(), EAF.FRENZY.dAtA());
		return this.crearDecepticon(EAF.FRENZY.nombre(), EAF.FRENZY.vida(), buffaloHMPCV, EAF.FRENZY.velH(), EAF.FRENZY.atH(), EAF.FRENZY.dAtH());
	}
	
	public Decepticon getBonecrusher(){
		Alterno duster = new AlternoTerrestre(EAF.BONECRUSHER.velA(), EAF.BONECRUSHER.atA(), EAF.BONECRUSHER.dAtA());
		return this.crearDecepticon(EAF.BONECRUSHER.nombre(), EAF.BONECRUSHER.vida(), duster, EAF.BONECRUSHER.velH(), EAF.BONECRUSHER.atH(), EAF.BONECRUSHER.dAtH());
		}
	
	/**
	 * Crea un Decepticon con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private Decepticon crearDecepticon(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		return new Decepticon(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
}

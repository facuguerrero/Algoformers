package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.BurbujaInmaculada;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.DobleCanion;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.Flash;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public interface Atacable extends Ubicable{
	
	public void recibirDanio(Decepticon decepticon, int poderAtaque);
	public void recibirDanio(AutoBot autobot, int poderAtaque);
	public void atacarEnemigo(AlgoFormer algoformerEnemigo, int poderAtaque);
	
	public void afectarConSuperficie(SuperficieAerea superficie);
	public void afectarConSuperficie(SuperficieTerrestre superficie);

	public void afectarConCapturable(DobleCanion dobleCanion);
	public void afectarConCapturable(BurbujaInmaculada burbujaInmaculada);
	public void afectarConCapturable(Flash flash);
	
}

package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class TipoDeUnidad {

	public abstract void afectarConSuperficie(SuperficieTerrestre superficie, AlgoFormer algoformer);
	public abstract void afectarConSuperficie(SuperficieAerea superficie, AlgoFormer algoformer);

}

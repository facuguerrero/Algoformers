package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoPantano extends EfectoTemporal {

	public EfectoPantano() {
		super(0, -1, new EfectoVelocidad(), 1);
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.guardarEfecto(this);
	}

}

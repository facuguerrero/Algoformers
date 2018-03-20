package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoVida extends TipoDeEfecto {

	public EfectoVida(){
		super();
	}
	
	@Override
	public void aplicarEn(AlgoFormer algoformer, EfectoTemporal efecto) {
		algoformer.guardarEfecto(efecto, this);
	}

	@Override
	public void aplicarEn(AlgoFormer algoformer, EfectoEstatico efecto) {
		algoformer.guardarEfecto(efecto, this);
	}
}

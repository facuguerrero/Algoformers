package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class TipoDeEfecto {	

	public TipoDeEfecto(){
	}
	
	public abstract void aplicarEn(AlgoFormer algoformer, EfectoTemporal efecto);
	public abstract void aplicarEn(AlgoFormer algoformer, EfectoEstatico efecto);
}


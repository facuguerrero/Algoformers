package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoEstatico extends Efecto{

	public EfectoEstatico(int multiplicador, int base, TipoDeEfecto tipo){
		super(multiplicador, base, tipo);
	}

	public void aplicarseEn(AlgoFormer algoformer){
		this.tipo.aplicarEn(algoformer, this);
	}
}

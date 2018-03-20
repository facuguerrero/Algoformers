package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Efecto {
	
	protected int multiplicador;
	protected int base;
	protected TipoDeEfecto tipo;
	
	public abstract void aplicarseEn(AlgoFormer algoformer);
	
	public Efecto(int multiplicador, int base, TipoDeEfecto tipo){
		this.multiplicador = multiplicador;
		this.base = base;
		this.tipo = tipo;
	}
	
	public int obtenerValorFijo() {
		return base;
	}
	
	public int obtenerValorMult() {
		return multiplicador;
	}	
	
}

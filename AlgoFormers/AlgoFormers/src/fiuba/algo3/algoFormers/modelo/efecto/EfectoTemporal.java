package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoTemporal extends Efecto{

	protected int turnos;

	public EfectoTemporal(int multiplicador, int base, TipoDeEfecto tipo, int turnos){
		 super(multiplicador, base, tipo);
		 this.turnos = turnos;
	}

	public void aplicarseEn(AlgoFormer algoformer){
		this.tipo.aplicarEn(algoformer, this);
	}

	public void restarTurno() {
		turnos--;
	}

	public boolean tiempoTerminado() {
		return (turnos <= 0);
	}

	public int turnos() {
		return this.turnos;
	}
}

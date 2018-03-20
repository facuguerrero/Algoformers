package fiuba.algo3.algoFormers.modelo.fabricas.superficies;

public enum DatosS {
	
	EFECTOPANTANO (0,-1, 1),
	EFECTOROCAS(0,0,1),
	EFECTOESPINA(-5,0, 1),
	EFECTONUBE(0,0,1),
	EFECTOTORMENTAPSIONICA(-40,0,0),
	EFECTONEBULOSAANDROMEDA(-100,0,3);
	
	private final int turnos;
	private final int multiplicador;
	private final int base;
	
	DatosS(int multiplicador, int base, int turnos){
		this.base=base;
		this.multiplicador = multiplicador;
		this.turnos = turnos;
	}

	public int getTurnos() {
		return turnos;
	}

	public int getBase() {
		return base;
	}

	public int getMultiplicador() {
		return multiplicador;
	}

}

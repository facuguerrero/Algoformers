package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos.UnidadAerea;

public class AlternoAereo extends Alterno {

	public AlternoAereo(int velocidad, int ataque, int distAtaque){
		super(velocidad, ataque, distAtaque);
		this.tipo= new UnidadAerea();
	}
	
}

package fiuba.algo3.algoFormers.modelo.capturables.bonus;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoVida;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class BurbujaInmaculada extends Bonus {

	private int id = 0002;

	public BurbujaInmaculada(){
		super(0, 0, new EfectoVida(), 3);
		this.nombre = "BurbujaInmaculada";
	}
	
	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarConCapturable(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BurbujaInmaculada other = (BurbujaInmaculada) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

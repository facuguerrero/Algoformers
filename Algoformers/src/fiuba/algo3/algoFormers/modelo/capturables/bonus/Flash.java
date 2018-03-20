package fiuba.algo3.algoFormers.modelo.capturables.bonus;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoVelocidad;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class Flash extends Bonus {

	public Flash() {
		super(200, 0, new EfectoVelocidad(), 4);
		this.nombre = "Flash";
	}

	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarConCapturable(this);
	}

}

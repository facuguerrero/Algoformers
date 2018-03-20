package fiuba.algo3.algoFormers.modelo.capturables.bonus;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoAtaque;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class DobleCanion extends Bonus {

	public DobleCanion() {
		super(100, 0, new EfectoAtaque(), 4);
		this.nombre = "DobleCanion";
	}
	
	public void afectar(Atacable atacable){
		atacable.afectarConCapturable(this);
	}
}

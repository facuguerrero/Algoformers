package fiuba.algo3.algoFormers.modelo.capturables.bonus;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.efecto.TipoDeEfecto;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;

public abstract class Bonus extends EfectoTemporal implements Capturable {
	
	protected String nombre;

	public Bonus(int multiplicador, int base, TipoDeEfecto tipo, int turnos) {
		super(multiplicador, base, tipo, turnos);
	}
	
	public abstract void afectar(Atacable atacable);
	
	public String getNombre(){
		return this.nombre;
	}
}

package fiuba.algo3.algoFormers.modelo.capturables;

import fiuba.algo3.algoFormers.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;

public class Chispa implements Capturable{

	private int id = 0;
	private String nombre = "Chispa";
	
	public Chispa(){}
	
	public void afectar(Atacable atacable){
		throw new FinDelJuegoException();
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
		Chispa other = (Chispa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}

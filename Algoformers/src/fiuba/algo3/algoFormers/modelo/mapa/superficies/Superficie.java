package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.efecto.Efecto;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Superficie {
	
	protected Efecto efecto;
	protected String nombre;
	
	public Superficie(String nombre, Efecto efecto){
		this.setEfecto(efecto);
		this.setNombre(nombre);
	}
	
	private void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	private void setEfecto(Efecto efecto){
		this.efecto = efecto;
	}

	public abstract void afectar(Atacable atacable);

	public void aplicarEfecto(AlgoFormer algoformer){
		this.efecto.aplicarseEn(algoformer);
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
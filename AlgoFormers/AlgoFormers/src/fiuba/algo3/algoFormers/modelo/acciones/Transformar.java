package fiuba.algo3.algoFormers.modelo.acciones;

import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Transformar implements Accion{

	private AlgoFormer personaje;
	
	public Transformar(AlgoFormer personaje){
		this.setPersonaje(personaje);
	}
	
	private void setPersonaje(AlgoFormer personaje){
		this.personaje = personaje;
	}
	
	public void ejecutar(){
		this.personaje.transformarse();
	}
}

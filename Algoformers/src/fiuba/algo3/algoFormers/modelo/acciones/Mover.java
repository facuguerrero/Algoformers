package fiuba.algo3.algoFormers.modelo.acciones;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Mover implements Accion {

	private Mapa mapa;
	private Direccion direccion;
	private AlgoFormer aMover;
	
	public Mover(Mapa mapa, AlgoFormer aMover ,Direccion direccion){
		this.setMapa(mapa);
		this.setAMover(aMover);
		this.setDireccion(direccion);
	}
	
	private void setMapa(Mapa mapa){
		this.mapa = mapa;
	}

	private void setAMover(AlgoFormer aMover){
		this.aMover = aMover;
	}
	
	private void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	public void ejecutar(){
		this.aMover.moverEnDireccion(this.direccion, this.mapa);
	}
}
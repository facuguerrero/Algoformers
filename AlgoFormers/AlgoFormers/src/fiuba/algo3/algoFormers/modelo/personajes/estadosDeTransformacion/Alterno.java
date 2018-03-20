package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoPantano;

public class Alterno extends EstadoDeTransformacion {

	public Alterno(int velocidad, int ataque, int distAtaque){
		super(velocidad, ataque, distAtaque);
	}
	
	public void guardarEfectoPantano(EfectoPantano efecto){
		this.velocidad.agregarEfectoTemporal(efecto);
	}
}

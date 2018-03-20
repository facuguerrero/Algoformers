package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.DobleCanion;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.Flash;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoAtaque;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoPantano;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVelocidad;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Velocidad;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos.TipoDeUnidad;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public abstract class EstadoDeTransformacion {

	protected Velocidad velocidad;
	protected Ataque ataque;
	protected TipoDeUnidad tipo;
	
	public EstadoDeTransformacion(int velocidad, int ataque, int distAtaque){
		this.setVelocidad(velocidad);
		this.setAtaque(ataque, distAtaque);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = new Velocidad(velocidad);
	}
	
	private void setAtaque(int ataque, int distAtaque){
		this.ataque = new Ataque(ataque, distAtaque);
	}
	
	public Ataque obtenerAtaque(){
		return this.ataque;
	}
	
	public ManejadorDeMovimientos crearManejadorMovimientos() {
		/*Funcion que le pide al objeto velocidad que devuelva un manejador
		 * de movimientos con los movimientos del algoformer en su modo actual.
		 */
		return this.velocidad.crearManejadorMovimientos();
	}
	
	public ManejadorDeAtaques crearManejadorAtaque() {
		/* Funcion que le pide al objeto ataque que devuelva un manejador de ataque
		 * con el poder de ataque y la distancia en su  modo actual.
		 */
		return this.ataque.crearManejadorAtaque();
	}
	
	public int getVelocidad(){
		return this.velocidad.getVelocidad();
	}
	
	public int getAtaque(){
		return this.ataque.getAtaque();
	}
	
	public int getDistanciaDeAtaque(){
		return this.ataque.getDistanciaDeAtaque();
	}

	public void afectarConSuperficie(SuperficieTerrestre superficie, AlgoFormer algoformer) {
		this.tipo.afectarConSuperficie(superficie, algoformer);
	}

	public void afectarConSuperficie(SuperficieAerea superficie, AlgoFormer algoformer) {
		this.tipo.afectarConSuperficie(superficie, algoformer);	
	}

	public void guardarEfectoTemporal(EfectoTemporal efecto, EfectoVelocidad tipo) {
		this.velocidad.agregarEfectoTemporal(efecto);
	}

	public void guardarEfectoEstatico(EfectoEstatico efecto, EfectoVelocidad tipo) {
		this.velocidad.agregarEfectoFijo(efecto);
	}
	
	public void guardarEfectoTemporal(EfectoTemporal efecto, EfectoAtaque tipo) {
		this.velocidad.agregarEfectoTemporal(efecto);
	}

	public void guardarEfectoEstatico(EfectoEstatico efecto, EfectoAtaque tipo) {
		this.ataque.agregarEfectoFijo(efecto);
	}

	public abstract void guardarEfectoPantano(EfectoPantano efecto);

	public void actualizarManejadorMovimiento(ManejadorDeMovimientos manejador) {
		this.velocidad.actualizarManejadorMovimiento(manejador);
	}

	public void actualizarAtributos() {
		this.ataque.actualizar();
		this.velocidad.actualizar();
	}

	public void afectarConCapturable(DobleCanion bonus) {
		this.ataque.agregarEfectoTemporal(bonus);		
	}

	public void afectarConCapturable(Flash bonus) {
		this.velocidad.agregarEfectoTemporal(bonus);		
	}
	
}

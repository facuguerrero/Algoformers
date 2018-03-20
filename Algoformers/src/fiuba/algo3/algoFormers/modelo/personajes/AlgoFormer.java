package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.BurbujaInmaculada;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.DobleCanion;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.Flash;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoAtaque;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoPantano;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVelocidad;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVida;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.EstadoDeTransformacion;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public abstract class AlgoFormer implements Atacable {

	protected String nombre;
	protected Vida vida;
	protected EstadoDeTransformacion estadoDeTransformacionActual;
	protected EstadoDeTransformacion estadoDeTransformacionOpuesto;
	protected ManejadorDeMovimientos manDeMovimientos;
	protected ManejadorDeAtaques manDeAtaques;
	
	public abstract void recibirDanio(Decepticon decepticon, int poderAtaque);
	public abstract void recibirDanio(AutoBot autobot, int poderAtaque);
	
	public AlgoFormer(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		this.setNombre(nombre);
		this.setVida(vida);
		this.setEstadosDeTransformacion(alterno, velocidadH, ataqueH, distAtaqueH);
		this.setManejadorMovimientos();
		this.setManejadorAtaques();
	}

	private void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	private void setManejadorMovimientos(){
		ManejadorDeMovimientos manejadorM = this.estadoDeTransformacionActual.crearManejadorMovimientos();
		this.manDeMovimientos = manejadorM;
	}

	private void setManejadorAtaques(){
		ManejadorDeAtaques manejadorA = this.estadoDeTransformacionActual.crearManejadorAtaque();
		this.manDeAtaques = manejadorA;
	}

	private void setVida(int vida){
		this.vida = new Vida(vida);
	}
	
	private void setEstadosDeTransformacion(Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		EstadoDeTransformacion humanoide = new Humanoide(velocidadH, ataqueH, distAtaqueH);
		this.estadoDeTransformacionActual = humanoide;
		this.estadoDeTransformacionOpuesto = alterno;
	}
	
	public void transformarse(){
		EstadoDeTransformacion estadoAux = this.estadoDeTransformacionActual;
		this.estadoDeTransformacionActual = this.estadoDeTransformacionOpuesto;
		this.estadoDeTransformacionOpuesto = estadoAux;
		this.setManejadorMovimientos();
		this.setManejadorAtaques();
	}
	
	public void moverEnDireccion(Direccion direccion, Mapa mapa){
		/*Funcion para mover un algoformer. Recibe una direccion de movimiento
		 * y el mapa. Esta delega su comportamiento en el manejador de movimiento.
		 */
		this.manDeMovimientos.moverEnDireccion(this, direccion,mapa);
		//chequea si no esta parado en la nebulosa de andromeda
		if(estadoDeTransformacionActual.getVelocidad() == 0)manDeMovimientos.setMovimientosRestantes(0);
	}
	
	public void atacarPosicion(Posicion posicion, Mapa mapa){
		/* Funcion delega su comportamiento en atacar de manejador de ataques.
		 *Recibe como parametro una posicion a la cual atacar y el mapa.
		 */
		this.manDeAtaques.atacar(this,posicion,mapa);
	}
	
	
	public void finalizarTurno(){
		/*Funcion para setear los manejadores de un algoformer en el momento
		en el que el algoformer es seleccionado como el personaje de turno.
		*/
		this.vida.actualizar();
		this.estadoDeTransformacionActual.actualizarAtributos();
		this.estadoDeTransformacionOpuesto.actualizarAtributos();
		this.setManejadorMovimientos();
		this.setManejadorAtaques();
	}
	
	public void afectarConCapturable(DobleCanion bonus){
		this.estadoDeTransformacionActual.afectarConCapturable(bonus);
		this.estadoDeTransformacionOpuesto.afectarConCapturable(bonus);
	}
	
	public void afectarConCapturable(BurbujaInmaculada bonus){
		this.vida.ponerEscudo(bonus.turnos());
	}
	
	public void afectarConCapturable(Flash bonus){
		this.estadoDeTransformacionActual.afectarConCapturable(bonus);
		this.estadoDeTransformacionOpuesto.afectarConCapturable(bonus);
	}
	
	public void afectarConSuperficie(SuperficieAerea superficie) {
		this.estadoDeTransformacionActual.afectarConSuperficie(superficie,this);
	}

	public void afectarConSuperficie(SuperficieTerrestre superficie) {
		this.estadoDeTransformacionActual.afectarConSuperficie(superficie,this);	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		AlgoFormer other = (AlgoFormer) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public void guardarEfecto(EfectoPantano efecto){
		this.estadoDeTransformacionActual.guardarEfectoPantano(efecto);
	}
	
	public void guardarEfecto(EfectoTemporal efecto, EfectoVida tipo) {
		this.vida.agregarEfectoTemporal(efecto);
	}
	
	public void guardarEfecto(EfectoTemporal efecto, EfectoVelocidad tipo) {
		this.estadoDeTransformacionActual.guardarEfectoTemporal(efecto, tipo);
		this.estadoDeTransformacionOpuesto.guardarEfectoTemporal(efecto, tipo);
		this.estadoDeTransformacionActual.actualizarManejadorMovimiento(this.manDeMovimientos);
	}
	
	public void guardarEfecto(EfectoTemporal efecto, EfectoAtaque tipo) {
		this.estadoDeTransformacionActual.guardarEfectoTemporal(efecto, tipo);
		this.estadoDeTransformacionOpuesto.guardarEfectoTemporal(efecto, tipo);
	}
	
	public void guardarEfecto(EfectoEstatico efecto, EfectoVida tipo) {
		this.vida.agregarEfectoFijo(efecto);
	}
	
	public void guardarEfecto(EfectoEstatico efecto, EfectoVelocidad tipo) {
		this.estadoDeTransformacionActual.guardarEfectoEstatico(efecto, tipo);	
		this.estadoDeTransformacionOpuesto.guardarEfectoEstatico(efecto, tipo);
	}
	
	public void guardarEfecto(EfectoEstatico efecto, EfectoAtaque tipo) {
		this.estadoDeTransformacionActual.guardarEfectoEstatico(efecto, tipo);
		this.estadoDeTransformacionOpuesto.guardarEfectoEstatico(efecto, tipo);
	}
	
//	public void sumarVidaA(int total) {
//		this.vida.sumarVidaA(total);
//	}
	
	public boolean muerto(){
		return this.vida.muerto();
	}
	
	//Metodos para las pruebas. No se deberian llamar en otras clases.
	public int getVida(){
		return this.vida.getVida();
	}

	public EstadoDeTransformacion getEstado() {
		return this.estadoDeTransformacionActual;
	}
	
	public int getVelocidad(){
		return this.estadoDeTransformacionActual.getVelocidad();
	}
	
	public int getAtaque(){
		return this.estadoDeTransformacionActual.getAtaque();
	}
	
	public int getDistanciaDeAtaque(){
		return this.estadoDeTransformacionActual.getDistanciaDeAtaque();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getMovRest(){
		return this.manDeMovimientos.getMovimientosRestantes();
	}
	
	public void resetearVida(){
		this.vida.resetear();
	}
	public String getNombreEstado() {
		if (Humanoide.class == this.estadoDeTransformacionActual.getClass()) return this.getNombre();
		return (this.getNombre() + "Alterno");
	}
}

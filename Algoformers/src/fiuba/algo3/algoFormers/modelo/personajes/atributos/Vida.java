package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Vida extends Atributo{
	
	private Escudo escudo;
	
	public Vida(int vida){
		super(vida);
		this.setEscudo();
	}
	
	private void setEscudo(){
		this.escudo = new Escudo();
	}
	
	public void descontarVida(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 */
		int danioTotal = this.calcularDanio(descuento);
		this.valorActual -= danioTotal;
	}
	
	private int calcularDanio(int danioOriginal){
		return this.escudo.calcularDanio(danioOriginal);
	}
	
	public void ponerEscudo(int turnos) {
		this.escudo.activar(turnos);		
	}
//
//	public void sumarVidaA(int total) {
//		total += this.valorActual;		
//	}

	public boolean muerto() {
		return (this.valorActual <= 0);
	}
	
	@Override
	public void actualizar(){
		this.escudo.actualizar();
	}
	
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.valorActual;
	}
}

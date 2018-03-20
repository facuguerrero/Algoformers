package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeEfectosTemporales;

public abstract class Atributo {
	
	protected ArrayList<EfectoEstatico> efectosEstaticos;
	protected ManejadorDeEfectosTemporales manejadorEfectosTemporales;
	//protected HashMap<EfectoTemporal, Integer> efectosTemporales;
	protected int valorActual;
	protected int valorOriginal;
	private int valorCalculado;//Esto esta aca por el scope de lambda expression
	
	public Atributo(int valor){
		efectosEstaticos = new ArrayList<EfectoEstatico>();
		//efectosTemporales = new HashMap<EfectoTemporal, Integer>();
		manejadorEfectosTemporales = new ManejadorDeEfectosTemporales();
		valorOriginal = valor;
		valorActual = valor;
	}
	
	public void agregarEfectoFijo(EfectoEstatico efecto){
		efectosEstaticos.remove(efecto);
		efectosEstaticos.add(efecto);
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}
	
	public void agregarEfectoTemporal(EfectoTemporal efecto){
		this.manejadorEfectosTemporales.agregarEfecto(efecto, efecto.turnos());
		this.valorActual = this.calcularValorActual(this.valorActual);
	}	
	
	public int valorActual(){
		return this.valorActual;
	}
	
	public void actualizar(){
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}

	public int calcularValorActual(int valorBase){
		this.valorCalculado = valorBase;
		for (int i = 0; i < efectosEstaticos.size(); i++){
			EfectoEstatico efecto = efectosEstaticos.get(i); 
			this.valorCalculado += efecto.obtenerValorFijo();
			this.valorCalculado += (valorBase*efecto.obtenerValorMult())/100; 
		}
		
		this.valorCalculado = this.manejadorEfectosTemporales.calcularValorActual(valorBase,
				this.valorCalculado);
		//Para la nebulosa de andromeda, el valor calculado va a ser negativo y por eso se restaura a cero
		if (valorCalculado < 0) valorCalculado = 0;
		return valorCalculado;
	}
	
	//Metodo para pruebas
	public void resetear(){
		this.valorActual = this.valorOriginal;
	}
	
}

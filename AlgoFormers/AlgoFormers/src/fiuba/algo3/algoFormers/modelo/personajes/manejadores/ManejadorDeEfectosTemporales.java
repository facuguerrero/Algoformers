package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;

public class ManejadorDeEfectosTemporales {
	protected HashMap<EfectoTemporal, Integer> efectosTemporales;
	
	public ManejadorDeEfectosTemporales(){
		efectosTemporales = new HashMap<EfectoTemporal, Integer>();
	}

	public void agregarEfecto(EfectoTemporal efecto, int turnos) {
		this.efectosTemporales.put(efecto,turnos);
	}
	
	public int calcularValorActual(int valorBase, int valorCalculado) {
		Set<EfectoTemporal> efectos = this.efectosTemporales.keySet();
		Iterator<EfectoTemporal> iter = efectos.iterator();
		HashMap<EfectoTemporal, Integer> efectosActualizados = new HashMap<EfectoTemporal, Integer>();
		while (iter.hasNext()){
			EfectoTemporal efecto = iter.next();
			valorCalculado = this.realizarIncrementos(valorCalculado, valorBase, efecto);
			if(this.chequearBorrado(efecto)){
				this.realizarBorrado(efecto);
			} 
			else {this.restarTurno(efectosActualizados, efecto);}	    
		}
		this.efectosTemporales = efectosActualizados;
		return valorCalculado;
	}
	
	private int realizarIncrementos(int valorCalc,int valorBase, EfectoTemporal efecto){
		valorCalc += efecto.obtenerValorFijo();
		valorCalc += (valorBase*efecto.obtenerValorMult())/100;
		return valorCalc;
	}
	
	private Boolean chequearBorrado(EfectoTemporal efecto){
		int turnos = this.efectosTemporales.get(efecto);
		if (turnos - 1 == 0){
			return true;
		} 
		return false;
	}
	
	private void realizarBorrado(EfectoTemporal efecto){
		this.efectosTemporales.remove(efecto);
	}
	
	private void restarTurno(HashMap<EfectoTemporal, Integer> efectosActualizados, 
			EfectoTemporal efecto){
		int turnos = this.efectosTemporales.get(efecto);
		efectosActualizados.put(efecto, turnos - 1);
	}
	
	
	
}

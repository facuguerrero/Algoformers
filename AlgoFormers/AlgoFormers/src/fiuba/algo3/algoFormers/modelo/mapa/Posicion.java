package fiuba.algo3.algoFormers.modelo.mapa;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;

public class Posicion {

	private int numeroFila;
	private int numeroColumna;


	public Posicion(int fila, int columna) {
		numeroFila = fila;
		numeroColumna = columna;
	}
	
	public Posicion sumarDireccion(Direccion direccion) {
		//Devuelve una nueva posicion con la direccion sumada
		return (new Posicion(direccion.SumarX(numeroFila), direccion.SumarY(numeroColumna)));
	}
	
	public int obtenerDistanciaFila(Posicion otraPosicion) {
		return (Math.abs(this.numeroFila - otraPosicion.numeroFila));
	}
	
	public int obtenerDistanciaColumna(Posicion otraPosicion) {
		return (Math.abs(this.numeroColumna - otraPosicion.numeroColumna));
	}

	//Metodos de comparacion.
	
	@Override
	public int hashCode() {
		final int numeroSemilla = 31;
		int resultado = 1;
		resultado = numeroSemilla * resultado + numeroFila;
		resultado = numeroSemilla * resultado + numeroColumna;
		return resultado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (numeroFila != other.numeroFila)
			return false;
		if (numeroColumna != other.numeroColumna)
			return false;
		return true;
	}
	
	
	
	//Metodos para pruebas.

	public int getX() {
		return numeroFila;
	}


	public int getY() {
		return numeroColumna;
	}
}

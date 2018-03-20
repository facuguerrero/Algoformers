package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Escudo {

	private int turnos;
	
	public Escudo(){
		this.setTurnos();
	}
	
	private void setTurnos(){
		this.turnos = 0;
	}
	
	public void activar(int turnos){
		this.turnos = turnos;
	}
	
	public int calcularDanio(int danioOriginal){
		if (turnos != 0) return 0;
		return danioOriginal;
	}
	
	public void actualizar(){
		if (this.turnos!= 0) this.turnos--;
	}
	
	
}


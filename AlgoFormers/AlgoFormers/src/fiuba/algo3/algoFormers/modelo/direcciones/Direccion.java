package fiuba.algo3.algoFormers.modelo.direcciones;

public abstract class Direccion {
	
	protected int x;
	protected int y;
	
	public int SumarX(int x) {
		return (this.x + x);
	}
	
	public int SumarY(int y){
		return (this.y + y);
	}
}

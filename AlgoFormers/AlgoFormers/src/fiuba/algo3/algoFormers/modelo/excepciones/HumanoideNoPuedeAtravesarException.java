package fiuba.algo3.algoFormers.modelo.excepciones;

public class HumanoideNoPuedeAtravesarException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4032650772494038878L;
	private static final String MENSAJE = "Movimiento invalido";
	
	public HumanoideNoPuedeAtravesarException(){
		super(MENSAJE);
	}
	
}

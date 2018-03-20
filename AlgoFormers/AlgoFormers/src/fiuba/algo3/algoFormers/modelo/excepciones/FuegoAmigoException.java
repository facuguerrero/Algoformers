package fiuba.algo3.algoFormers.modelo.excepciones;

public class FuegoAmigoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3463462040627752618L;
	private static String MENSAJE = " FUEGO AMIGO";
	
	public FuegoAmigoException(){
		super(MENSAJE);
	}
}

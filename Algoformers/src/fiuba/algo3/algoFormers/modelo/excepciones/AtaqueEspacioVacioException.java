package fiuba.algo3.algoFormers.modelo.excepciones;

public class AtaqueEspacioVacioException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String MENSAJE = "En ese lugar no hay nada";
	public AtaqueEspacioVacioException(){
		super(MENSAJE);
	}
}	

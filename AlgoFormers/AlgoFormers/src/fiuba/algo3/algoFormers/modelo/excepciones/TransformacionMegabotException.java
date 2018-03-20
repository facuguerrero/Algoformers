package fiuba.algo3.algoFormers.modelo.excepciones;

public class TransformacionMegabotException extends RuntimeException {

	private static final long serialVersionUID = 2926924774264468746L;
	private static final String mensaje = "No se puede transformar un MegaBot";
	
	public TransformacionMegabotException(){
		super(mensaje);
	}
}

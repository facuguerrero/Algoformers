package fiuba.algo3.algoFormers.modelo.excepciones;

public class SeleccionPersonajeEnemigoException extends RuntimeException {

	private static final long serialVersionUID = 295923324784585650L;
	private static String MENSAJE = "No se puede seleccionar un personaje enemigo.";
	
	public SeleccionPersonajeEnemigoException(){
		super(MENSAJE);
	}
	
}

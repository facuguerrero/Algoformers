package fiuba.algo3.algoFormers.modelo.excepciones;

public class FueraDelMapaException extends RuntimeException{

	private static final long serialVersionUID = -4220290475790914270L;
	private static String MENSAJE ="Se termino el mapa";
	
	public FueraDelMapaException(){
		super(MENSAJE);
	}
}

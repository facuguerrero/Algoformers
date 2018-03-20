package fiuba.algo3.algoFormers.modelo.excepciones;

public class FueraDeRangoParaCombinarException extends RuntimeException {

	private static final long serialVersionUID = 7411329919776169169L;
	private static final String MENSAJE = "Los AlgoFormers no estan en rango para combinarse";
	
	public FueraDeRangoParaCombinarException(){
		super(MENSAJE);
	}
	
}

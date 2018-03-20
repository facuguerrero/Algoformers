package fiuba.algo3.algoFormers.modelo.excepciones;

public class EquipoNoCompletoException extends RuntimeException {

	private static final long serialVersionUID = -431038404800846610L;
	private static final String MENSAJE = "El equipo no esta completo para combinarse";

	public EquipoNoCompletoException(){
		super(MENSAJE);
	}
	
}

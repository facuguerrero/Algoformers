package fiuba.algo3.algoFormers.modelo.excepciones;

public class MovimientosAgotadosException extends RuntimeException {

	private static final long serialVersionUID = -4071718016439521079L;
	private static String MENSAJE = "No hay mas nafta!!";
	
	public MovimientosAgotadosException(){
		super(MENSAJE);
		
	}
}

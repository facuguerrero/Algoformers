package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;

public class BotonDireccionArriba extends BotonDireccion {
	
	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/Arriba.png";
	
	public BotonDireccionArriba(Juego juego,ContenedorTablero tablero){
		super(juego, new DirArriba(), imagen, tablero);
	}
	
}

package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoIzq;

public class BotonDireccionAbajoIzquierda extends BotonDireccion {

	private final static String imagen ="file:src/fiuba/algo3/algoFormers/vista/imagenes/AbajoIzquierda.png";
	
	public BotonDireccionAbajoIzquierda(Juego juego, ContenedorTablero tablero) {
		super(juego, new DirAbajoIzq(), imagen, tablero);
	}

}

package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;

public class BotonDireccionArribaIzquierda extends BotonDireccion {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/ArribaIzquierda.png";
	
	public BotonDireccionArribaIzquierda(Juego juego, ContenedorTablero tablero) {
		super(juego, new DirArribaIzq(), imagen, tablero);
	}

}

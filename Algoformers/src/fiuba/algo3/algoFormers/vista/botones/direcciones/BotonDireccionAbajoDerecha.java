package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;

public class BotonDireccionAbajoDerecha extends BotonDireccion {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/AbajoDerecha.png";
	
	public BotonDireccionAbajoDerecha(Juego juego,ContenedorTablero tablero) {
		super(juego, new DirAbajoDer(), imagen, tablero);
	}

}

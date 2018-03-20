package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;

public class BotonDireccionAbajo extends BotonDireccion {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/Abajo.png";
	
	public BotonDireccionAbajo(Juego juego,ContenedorTablero tablero) {
		super(juego, new DirAbajo(), imagen, tablero);
	}

}

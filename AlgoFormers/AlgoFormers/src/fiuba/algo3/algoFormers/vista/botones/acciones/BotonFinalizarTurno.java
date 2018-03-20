package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonFinalizarTurno;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;

public class BotonFinalizarTurno extends BotonImagen {

	private Juego juego;
	
	public BotonFinalizarTurno(Juego juego, ContenedorTablero tablero){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/FinalizarTurno.png", 184, 108);
		this.setJuego(juego);
		this.setHandler(tablero);
	}

	private void setJuego(Juego juego) {
		this.juego = juego;	
	}
	
	private void setHandler(ContenedorTablero tablero){
		HandlerBotonFinalizarTurno handler = new HandlerBotonFinalizarTurno(this.juego, tablero);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}

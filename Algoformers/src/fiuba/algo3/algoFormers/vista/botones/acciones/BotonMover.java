package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonMover;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;

public class BotonMover extends BotonImagen {
	
	private Juego juego;
	
	public BotonMover(Juego juego, ContenedorTablero tablero){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/Mover.png", 150, 54);
		this.setJuego(juego);
		this.setHandler(tablero);
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setHandler(ContenedorTablero tablero){
		HandlerBotonMover handler = new HandlerBotonMover(this.juego, tablero);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}

}

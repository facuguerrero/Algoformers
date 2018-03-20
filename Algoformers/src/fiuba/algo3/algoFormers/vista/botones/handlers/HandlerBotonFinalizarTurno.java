package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;

public class HandlerBotonFinalizarTurno implements EventHandler<ActionEvent>{

	private Juego juego;
	private ContenedorTablero contenedor;
	
	public HandlerBotonFinalizarTurno(Juego juego, ContenedorTablero tablero){
		this.setJuego(juego);
		this.setContenedor(tablero);
	}

	private void setContenedor(ContenedorTablero tablero) {
		this.contenedor = tablero;
		
	}

	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.juego.finalizarTurno();
		this.contenedor.armarTablero(this.juego);
	}

}

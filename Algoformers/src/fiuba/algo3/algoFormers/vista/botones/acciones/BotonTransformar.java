package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonTransformar;

public class BotonTransformar extends BotonImagen {

	private Juego juego;
	
	public BotonTransformar(Juego juego){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/Transformar.png", 210, 54);
		this.setJuego(juego);
		this.setHandler();
	}

	private void setJuego(Juego juego) {
		this.juego = juego;	
	}
	
	private void setHandler(){
		HandlerBotonTransformar handler = new HandlerBotonTransformar(this.juego);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}

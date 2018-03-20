package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonCombinar;

public class BotonCombinar extends BotonImagen {

	private Juego juego;
	
	public BotonCombinar(Juego juego){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/Combinar.png", 150, 54);
		this.setJuego(juego);
		this.setHandler();
	}

	private void setJuego(Juego juego) {
		this.juego = juego;	
	}
	
	private void setHandler(){
		HandlerBotonCombinar handler = new HandlerBotonCombinar(this.juego);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}

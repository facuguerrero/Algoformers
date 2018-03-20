package fiuba.algo3.algoFormers.vista.botones.acciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonAtacar;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;

public class BotonAtacar extends BotonImagen {

	private Juego juego;
	
	public BotonAtacar(Juego juego){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/Atacar.png", 150, 54);
		this.setJuego(juego);
		this.setHandler();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setHandler(){
		HandlerBotonAtacar handler = new HandlerBotonAtacar(this.juego);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
}

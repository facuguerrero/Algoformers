package fiuba.algo3.algoFormers.vista.botones.personajes;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonPersonaje;

public class BotonPersonaje extends BotonImagen{

	public BotonPersonaje(Juego juego, AlgoFormer algo) {
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + algo.getNombre() + ".png", 60, 60);
		this.setHandler(juego, algo);
	}
	
	private void setHandler(Juego juego, AlgoFormer algo){
		HandlerBotonPersonaje handler = new HandlerBotonPersonaje(juego, this, algo);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}

}

package fiuba.algo3.algoFormers.vista.botones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonCancelar;

public class BotonCancelar extends BotonImagen {

	public BotonCancelar(){
		super("file:src/fiuba/algo3/algoFormers/vista/imagenes/Cancelar.png", 150, 54);
		this.setHandler();
	}
	
	private void setHandler(){
		HandlerBotonCancelar handler = new HandlerBotonCancelar(this);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}

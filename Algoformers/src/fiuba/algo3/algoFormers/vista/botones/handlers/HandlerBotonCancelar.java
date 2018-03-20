package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class HandlerBotonCancelar implements EventHandler<ActionEvent> {

	private Button boton;
	
	public HandlerBotonCancelar(Button boton){
		this.setBoton(boton);
	}
	
	private void setBoton(Button boton){
		this.boton = boton;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Stage stage = (Stage) this.boton.getScene().getWindow();		
		stage.close();
	}

}

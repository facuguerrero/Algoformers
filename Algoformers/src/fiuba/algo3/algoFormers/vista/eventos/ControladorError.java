package fiuba.algo3.algoFormers.vista.eventos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControladorError {

	@FXML
	private Label MensajeError;
	
	public void initData(String mensaje){
		this.MensajeError.setText(mensaje);
	}
}

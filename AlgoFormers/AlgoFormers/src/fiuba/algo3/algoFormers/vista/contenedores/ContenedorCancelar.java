package fiuba.algo3.algoFormers.vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import fiuba.algo3.algoFormers.vista.botones.BotonCancelar;

public class ContenedorCancelar extends HBox{

	public ContenedorCancelar(){
		super();
		this.setCancelar();
		this.setAlignment(Pos.CENTER);
	}
	
	private void setCancelar(){
		Button boton = new BotonCancelar();
		this.getChildren().add(boton);
	}
	
}

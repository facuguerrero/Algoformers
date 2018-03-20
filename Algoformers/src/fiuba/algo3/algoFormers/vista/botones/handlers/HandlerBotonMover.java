package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorMoverEmergente;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;

public class HandlerBotonMover implements EventHandler<ActionEvent>{

	private Juego juego;
	private Scene ventanaEmergente;
	
	public HandlerBotonMover(Juego juego, ContenedorTablero tablero){
		this.setJuego(juego);
		this.setVentanaEmergente(tablero);
		
	}

	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setVentanaEmergente(ContenedorTablero tablero){
		ContenedorMoverEmergente contenedorEmergente = new ContenedorMoverEmergente(this.juego, tablero);
		this.ventanaEmergente = new Scene(contenedorEmergente);

	}
	
	@Override
	public void handle(ActionEvent event) {
		Stage stage = new Stage();
		stage.setTitle("Mover");
		stage.setScene(this.ventanaEmergente);
		stage.show();
	}

}

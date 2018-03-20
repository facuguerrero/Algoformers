package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;

public class HandlerBotonDireccion implements EventHandler<ActionEvent>{
	
	private Juego juego;
	private Button boton;
	private Direccion direccion;
	private ContenedorTablero contenedor;
	
	public HandlerBotonDireccion(Juego juego, Direccion direccion, 
			Button boton, ContenedorTablero tablero){
		this.setJuego(juego);
		this.setBoton(boton);
		this.setDireccion(direccion);
		this.setContenedor(tablero);
	}
	
	private void setContenedor(ContenedorTablero tablero) {
		this.contenedor = tablero;
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}

	private void setBoton(Button boton){
		this.boton = boton;
	}
	
	private void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juego.mover(this.direccion);
		this.contenedor.armarTablero(this.juego);
		Stage stage = (Stage) this.boton.getScene().getWindow();
		stage.close();
	}

}

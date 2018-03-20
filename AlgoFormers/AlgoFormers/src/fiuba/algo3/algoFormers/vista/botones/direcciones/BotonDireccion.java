package fiuba.algo3.algoFormers.vista.botones.direcciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonDireccion;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;

public class BotonDireccion extends BotonImagen {

	protected Juego juego;
	protected Direccion direccion;
	
	public BotonDireccion(Juego juego, Direccion direccion,
			String urlImagen, ContenedorTablero tablero){
		super(urlImagen, 50, 50);
		this.setJuego(juego);
		this.setDireccion(direccion);
		this.setHandler(tablero);
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	private void setHandler(ContenedorTablero tablero){
		HandlerBotonDireccion handler = new HandlerBotonDireccion(this.juego, this.direccion,
				this, tablero);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}

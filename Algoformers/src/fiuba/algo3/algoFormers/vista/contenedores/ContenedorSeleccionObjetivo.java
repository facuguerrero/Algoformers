package fiuba.algo3.algoFormers.vista.contenedores;

import java.util.Set;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ContenedorSeleccionObjetivo extends HBox{

	private Jugador jugador;
	private Juego juego;
	
	public ContenedorSeleccionObjetivo(Juego juego){
		this.setJuego(juego);
		this.setJugador(juego);
		this.distribuirPersonajes();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setJugador(Juego juego){
//		this.jugador = juego.getJugadorActual();
	}
	
	private void distribuirPersonajes(){
//		this.agregarOptimus(this.juego);
//		Set<AlgoFormer> personajes = (this.juego.getJugadorActual()).getPersonajes();//.getPersonajes();
//		personajes.forEach((personaje) -> {
//			if (personaje.getNombre() == "Optimus Prime")this.agregarOptimus(this.juego);
//			else if (personaje.getNombre() == "Bumblebee") this.agregarBumblebee(juego);
//			else if (personaje.getNombre() == "Ratchet") this.agregarRatchet(juego);
//			else if (personaje.getNombre() == "Megatron") this.agregarMegatron(juego);
//			else if (personaje.getNombre() == "Frenzy") this.agregarFrenzy(juego);
//			else if (personaje.getNombre() == "Bonecrusher") this.agregarBonecrusher(juego);
//		});
	}
//	
//	private void agregarOptimus(Juego juego){
//		Button boton = new BotonOptimus(juego);
//		this.getChildren().add(boton);
//	}
//	
//	private void agregarBumblebee(Juego juego){
//		Button boton = new BotonBumblebee(juego);
//		this.getChildren().add(boton);
//	}
//	
//	private void agregarRatchet(Juego juego){
//		Button boton = new BotonRatchet(juego);
//		this.getChildren().add(boton);
//	}
//	
//	private void agregarFrenzy(Juego juego){
//		Button boton = new BotonFrenzy(juego);
//		this.getChildren().add(boton);
//	}
//	
//	private void agregarMegatron(Juego juego){
//		Button boton = new BotonMegatron(juego);
//		this.getChildren().add(boton);
//	}
//	
//	private void agregarBonecrusher(Juego juego){
//		Button boton = new BotonBonecrusher(juego);
//		this.getChildren().add(boton);
//	}
//	
}

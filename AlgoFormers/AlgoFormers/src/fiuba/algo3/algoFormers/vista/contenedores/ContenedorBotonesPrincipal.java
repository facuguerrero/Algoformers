package fiuba.algo3.algoFormers.vista.contenedores;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonPersonaje;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ContenedorBotonesPrincipal extends GridPane{

	private Button mover;
	private Button atacar;
	private Button combinar;
	private Button transformar;
	private Button finalizarTurno;
	private Juego juego;
	private GridPane botonesJugadores;
	private ArrayList algoformersActuales;
	
	public ContenedorBotonesPrincipal(Button mover, Button atacar, Button transformar, Button combinar,
			Button finalizarTurno, Juego juego){
		this.setMover(mover);
		this.setAtacar(atacar);
		this.setTransformar(transformar);
		this.setCombinar(combinar);
		this.setFinalizarTurno(finalizarTurno);
		this.juego = juego;
		this.setBotonesPersonajes();
		this.setImagenesLaterales();
		this.distribuirBotones();
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setFondo();
	}
	


	public void setBotonesPersonajes() {
		this.botonesJugadores = new GridPane();
		for(int i = 0; i < 3; i++){
			this.algoformersActuales = this.juego.getAlgoformersActuales();
			botonesJugadores.add(new BotonPersonaje(this.juego, (AlgoFormer) this.algoformersActuales.get(i)), i, 0);
		}
		
	}

	private void setImagenesLaterales() {
		ImageView imagenAB = new ImageView(new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/AutoBot.png"));
		imagenAB.setFitHeight(50);
		imagenAB.setFitWidth(50);
		
		ImageView imagenD = new ImageView(new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/Decepticon.png"));
		imagenD.setFitHeight(50);
		imagenD.setFitWidth(50);
		
		VBox contenedorImagenes = new VBox(imagenAB, imagenD);
		contenedorImagenes.setAlignment(Pos.CENTER);
		this.add(contenedorImagenes, 0, 0);
	}

	private void distribuirBotones(){
		this.add(this.botonesJugadores, 1, 0);
		this.add(this.mover, 4, 0);
		this.add(this.atacar, 5, 0);
		this.add(this.transformar, 6, 0);
		this.add(this.combinar, 7, 0);
		this.add(this.finalizarTurno, 8, 0);
	}
	
	private void setFondo(){
	   	Image imagenPanel = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
	   	BackgroundImage imagen = new BackgroundImage(imagenPanel,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagen));
	}
	
	private void setMover(Button mover){this.mover = mover;}
	private void setAtacar(Button atacar){this.atacar = atacar;}
	private void setCombinar(Button combinar){this.combinar = combinar;}
	private void setTransformar(Button transformar){this.transformar = transformar;}
	private void setFinalizarTurno(Button finalizarTurno){this.finalizarTurno = finalizarTurno;}

	public void actualizarBotonesPersonajes(Juego juegoActual) {
		this.juego = juegoActual;
		this.getChildren().remove(this.botonesJugadores);
		this.setBotonesPersonajes();
		this.add(this.botonesJugadores, 1, 0);
		
	}
	
}

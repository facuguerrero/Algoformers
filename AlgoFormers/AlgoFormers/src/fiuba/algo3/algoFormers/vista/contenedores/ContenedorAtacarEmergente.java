package fiuba.algo3.algoFormers.vista.contenedores;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class ContenedorAtacarEmergente extends VBox{
	
	private ContenedorSeleccionObjetivo seleccion;
	private ContenedorCancelar cancelar;
	
	public ContenedorAtacarEmergente(Juego juego){
		this.setSeleccionObjetivo(juego);
		this.setContenedorCanclear();
		this.setFondo();
		this.getChildren().addAll(this.seleccion, this.cancelar);
	}
	
	private void setFondo(){
//	   	File file = new File("/home/rodrigo/git/PruebasJavaFX/Etc/FondoPanelBotones.png");
		Image imagenPanel = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
	   	BackgroundImage imagen = new BackgroundImage(imagenPanel,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagen));
	}
	
	private void setSeleccionObjetivo(Juego juego){
		this.seleccion = new ContenedorSeleccionObjetivo(juego);
	}
	
	private void setContenedorCanclear(){
		this.cancelar = new ContenedorCancelar();
	}

}

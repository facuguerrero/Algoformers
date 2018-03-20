package fiuba.algo3.algoFormers.vista.eventos;

import java.io.File;

import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControladorVictoria {

    @FXML
    private Label CartelGanador;

    @FXML
    private ImageView ImagenVictoria;

    @FXML
    private ImageView ImagenTrofeo;
    
    private Jugador ganador;
    private static final String autobots = "file:src/fiuba/algo3/algoFormers/vista/imagenes/VictoriaAutoBots.png";
    private static final String decepticons = "file:src/fiuba/algo3/algoFormers/vista/imagenes/VictoriaDecepticons.png";
    
    private void setGanador(Jugador ganador){
    	this.ganador = ganador;
    }
    
    private void displayImagen(){
    	if (this.ganador.getClass() == JugadorAutobots.class){
    		ImagenVictoria.setImage(new Image(autobots));
    	}
    	if (this.ganador.getClass() == JugadorDecepticons.class){
    		ImagenVictoria.setImage(new Image(decepticons));
    	}
    	ImagenTrofeo.setImage(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/Trofeo.png")));
    	CartelGanador.setText((this.ganador.getNombre() + " GANASTE!"));
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/Victoria.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    }

    public void initData(Jugador ganador){
    	this.setGanador(ganador);
    	this.displayImagen();
    }
    
}

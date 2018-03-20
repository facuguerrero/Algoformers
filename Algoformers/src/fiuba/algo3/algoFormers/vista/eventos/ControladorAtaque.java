package fiuba.algo3.algoFormers.vista.eventos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.EquipoDestruidoException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ControladorAtaque {

	@FXML
	private Label Vida1;
	@FXML
	private Label Vida2;
	@FXML
	private Label Vida3;
    @FXML
    private ImageView ImagenEnemigo1;
    @FXML
    private RadioButton SeleccionEnemigo1;
    @FXML
    private RadioButton SeleccionEnemigo2;
    @FXML
    private RadioButton SeleccionEnemigo3;
    @FXML
    private ImageView ImagenEnemigo2;
    @FXML
    private ImageView ImagenEnemigo3;
    @FXML
    private Label CartelMensaje;
    @FXML
    private Button BotonCancelar;
    @FXML
    private Button BotonAtacar;
    @FXML
    private Label NotificacionError;
    
	private Juego juego;
	private ControladorJuego controlador;

	private AlgoFormer personajeUno;
	private AlgoFormer personajeDos;
	private AlgoFormer personajeTres;
	private AlgoFormer elegido;
	private Button botonAtacar;
	private static final String normal = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private static final String presionado = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";

    @FXML
    void Atacar(ActionEvent event) throws IOException {
    	if (!this.enemigoSeleccionado()) return;
    	Posicion posicion = this.juego.getPosicionAlgoformer(this.elegido);
    	try{this.juego.atacar(posicion);} 
    	catch(AtaqueFueraDeRangoException e){
    		NotificacionError.setText(e.getMessage());
    		return;
    	}
    	catch(EquipoDestruidoException e){
    		this.controlador.armarTablero();
        	this.CerrarVentana(event);
        	this.juego.finalizarTurno();
    		this.controlador.finalizarJuego();
    		return;
    	}
    	int numDisparo = 1 + (int)(Math.random() * ((3 - 1) + 1));
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/Disparo"+Integer.toString(numDisparo) +".mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    	this.controlador.setJugador(juego.getJugadorActual());
    	this.controlador.armarTablero();
    	this.controlador.finAccion();
    	this.botonAtacar.setDisable(false);
    	this.CerrarVentana(event);
    }
    
    private boolean enemigoSeleccionado(){
    	if (!this.SeleccionEnemigo1.isSelected() && !this.SeleccionEnemigo2.isSelected() && !this.SeleccionEnemigo3.isSelected()){
    		this.NotificacionError.setText("Debe elegir a un enemigo");
    		return false;
    	}
    	return true;
    }

    @FXML
    void CancelarAtaque(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	this.CerrarVentana(event);
    }
    
    public void CerrarVentana(ActionEvent event){
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    	this.botonAtacar.setDisable(false);
    }

    @FXML
    void SeleccionarEnemigo1(ActionEvent event){
    	this.seleccionarRadio(this.SeleccionEnemigo1);
    	this.deseleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo3);
    	this.elegido= this.personajeUno;
    }

    @FXML
    void SeleccionarEnemigo2(ActionEvent event) {
    	this.seleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo1);
    	this.deseleccionarRadio(this.SeleccionEnemigo3);
    	this.elegido= this.personajeDos;
    }

    @FXML
    void SeleccionarEnemigo3(ActionEvent event) {
    	this.seleccionarRadio(this.SeleccionEnemigo3);
    	this.deseleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo1);
    	this.elegido= this.personajeTres;
    }
    
	public void initData(Juego juego, ControladorJuego controlador, Button botonAtacar) {
		this.juego = juego;
		this.controlador = controlador;
		this.botonAtacar = botonAtacar;
		this.setJugador(this.juego.getJugadorOpuesto());
		this.setDisenioBotones();
	}
	
    private void deseleccionarRadio(RadioButton boton){
    	boton.setSelected(false);
    	boton.setStyle("-fx-background-color: transparent;");
    }
    
    private void seleccionarRadio(RadioButton boton){
    	boton.setSelected(true);
    	boton.setStyle("-fx-shadow-color: black;");
    }
    
    private void setEstiloRadio(String nombre, ImageView imagen){
    	imagen.setImage(new Image((("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombre + ".png"))));
    	imagen.setStyle("-fx-background-color: transparent;");
    }
	private void setJugador(Jugador jugador){
		Set<AlgoFormer> personajes  = jugador.getPersonajes();
		ArrayList<AlgoFormer> guardar = new ArrayList<AlgoFormer>();
		personajes.forEach((personaje) -> guardar.add(personaje));
		int tam = guardar.size();
		AlgoFormer uno=null, dos=null, tres=null;
		uno = guardar.get(0);
		if (tam > 1) dos = guardar.get(1);
		if (tam > 2) tres = guardar.get(2);
		this.setPersonajes(uno, dos, tres);
	}
	
	public void setPersonajes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		if (uno != null){
			this.personajeUno = uno;
			this.setEstiloRadio(uno.getNombreEstado(), this.ImagenEnemigo1);
			this.setLabel(this.Vida1, uno.getVida());
		} else {this.desactivar(this.ImagenEnemigo1, this.SeleccionEnemigo1, this.Vida1);}
		if (dos != null){
			this.personajeDos = dos;
			this.setEstiloRadio(dos.getNombreEstado(), this.ImagenEnemigo2);
			this.setLabel(this.Vida2, dos.getVida());
		} else {this.desactivar(this.ImagenEnemigo2, this.SeleccionEnemigo2, this.Vida2);}
		if (tres != null){
			this.personajeTres = tres;
			this.setEstiloRadio(tres.getNombreEstado(), this.ImagenEnemigo3);
			this.setLabel(this.Vida3, tres.getVida());
		} else {this.desactivar(this.ImagenEnemigo3, this.SeleccionEnemigo3, this.Vida3);;}
	}
	 
	private void setLabel(Label etiqueta, int valor){
		etiqueta.setText("Vida: " + valor);
		etiqueta.setVisible(true);
	}
	
	private void desactivar(ImageView imagen, RadioButton radio, Label etiqueta){
		imagen.setVisible(false);
		radio.setVisible(false);
		etiqueta.setVisible(false);
	}
	
	private void setDisenioBotones(){
		this.setDisenio(BotonAtacar, "Atacar", 36, 100);
		this.setDisenio(BotonCancelar, "Cancelar", 36, 100);
	}
	
	private void setDisenio(Button boton, String url, int alto, int ancho){	
		boton.setText("");
		boton.setStyle(normal);
		ImageView imagen = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + url + ".png")));
		imagen.setFitHeight(alto);
		imagen.setFitWidth(ancho);
		boton.setGraphic(imagen);
		boton.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {boton.setStyle(presionado);}});
		boton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {boton.setStyle(normal);}});
	}
	  
}

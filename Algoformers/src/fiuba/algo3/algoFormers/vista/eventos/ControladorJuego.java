package fiuba.algo3.algoFormers.vista.eventos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.excepciones.EquipoNoCompletoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDeRangoParaCombinarException;
import fiuba.algo3.algoFormers.modelo.excepciones.TransformacionMegabotException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ControladorJuego {

	private AlgoFormer personajeUno;
	private AlgoFormer personajeDos;
	private AlgoFormer personajeTres;
	
    @FXML
    private Button BotonSalir;
    @FXML
    private Button BotonFinalizarTurno;
    @FXML
    private Button BotonCombinar;
    @FXML
    private Button BotonTransformar;
    @FXML
    private Button BotonAtacar;
    @FXML
    private Button BotonMover;
    @FXML
    private Label Vida1;
    @FXML
    private Label Poder1;
    @FXML
    private Label Rango1;
    @FXML
    private Label Vel1;
    @FXML
    private Label Vida2;
    @FXML
    private Label Poder2;
    @FXML
    private Label Rango2;
    @FXML
    private Label Vel2;
    @FXML
    private Label Vida3;
    @FXML
    private Label Poder3;
    @FXML
    private Label Rango3;
    @FXML
    private Label Vel3;
    @FXML
    private ToggleButton Personaje2;
    @FXML
    private ToggleButton Personaje3;
    @FXML
    private ToggleButton Personaje1;

	private Juego juego;
	private ContenedorTablero tablero;
	private ToggleButton toggleActual;
	private AlgoFormer personajeActual;
	private boolean accionado = false;
	private static final String normal = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private static final String presionado = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
	

    @FXML
    void Salir(ActionEvent event) {
    	System.exit(0);
    }
	
    @FXML
    void Atacar(ActionEvent event) throws IOException {
    	if (accionado) return;
    	//se abre la ventana de ataque
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorAtaque.fxml"));
    	BorderPane contenedorAtaque = (BorderPane) loader.load();
    	this.setBackground(contenedorAtaque);
    	
    	//obtengo el controlador para asignarle el juego
    	ControladorAtaque controlador = loader.<ControladorAtaque>getController();
    	controlador.initData(this.juego, this, this.BotonAtacar);
    
    	this.BotonAtacar.setDisable(true);
    	Stage stage = new Stage();
		stage.setTitle("Atacar");
    	stage.setScene(new Scene(contenedorAtaque));
    	stage.show();
    }

    @FXML
    void Combinar(ActionEvent event) throws IOException {
    	if (accionado) return;
    	try{this.juego.combinar();}
    	catch(FueraDeRangoParaCombinarException | EquipoNoCompletoException e ){
    		this.mostrarError(e.getMessage());
    		return;
    	}
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/Transformacion.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    	this.setJugador(juego.getJugadorActual());
    	this.tablero.armarTablero(this.juego);
    	this.finAccion();
    }

    @FXML
    void FinalzarTurno(ActionEvent event) {
    	this.juego.finalizarTurno();
    	this.setJugador(juego.getJugadorActual());
    	this.tablero.armarTablero(this.juego);
    	this.finAccion();
    }

    @FXML
    void Mover(ActionEvent event) throws IOException {
    	//se abre la ventana de movimiento
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorMovimiento.fxml"));
    	BorderPane contenedorMovimiento = (BorderPane) loader.load();
    	this.setBackground(contenedorMovimiento);
    	
    	//obtengo el controlador para asignarle el juego
    	ControladorMovimiento controlador = loader.<ControladorMovimiento>getController();
    	controlador.initData(this.juego, this.tablero, this, this.BotonMover);
    	
    	this.BotonMover.setDisable(true);
    	Stage stage = new Stage();
		stage.setTitle("Mover");
    	stage.setScene(new Scene(contenedorMovimiento));
    	stage.show();
    }
    
    public void accionado(){
    	this.accionado = true;
    }

    public void finAccion(){
    	this.accionado = false;
    }
    
    public void finalizarJuego() throws IOException{
    	this.mostrarVictoria();
    }
    
    private void mostrarVictoria() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorVictoria.fxml"));
    	VBox contenedorVictoria = (VBox) loader.load();
    	this.setBackgroundVictoria(contenedorVictoria);
    	ControladorVictoria controlador = loader.<ControladorVictoria>getController();
    	controlador.initData(this.juego.getJugadorActual());
    	Stage stage = new Stage();
		stage.setTitle("Victoria");
    	stage.setScene(new Scene(contenedorVictoria));
    	stage.show();
    }

	@FXML
    void SeleccionarPersonajeActual1(ActionEvent event) {
    	if (accionado) return;
    	this.deseleccionarToggle(this.Personaje2, this.personajeDos);
    	this.deseleccionarToggle(this.Personaje3, this.personajeTres);
    	this.seleccionarToggle(this.Personaje1, this.personajeUno);
    	this.juego.setPersonajeActual(this.personajeUno);
    }

    @FXML
    void SeleccionarPersonajeActual2(ActionEvent event) {
    	if (accionado) return;
    	this.deseleccionarToggle(Personaje1, personajeUno);
    	this.deseleccionarToggle(Personaje3, personajeTres);
    	this.seleccionarToggle(Personaje2, personajeDos);
    	this.juego.setPersonajeActual(this.personajeDos);
    }

    @FXML
    void SeleccionarPersonajeActual3(ActionEvent event) {
    	if (accionado) return;
    	this.deseleccionarToggle(Personaje2, personajeDos);
    	this.deseleccionarToggle(Personaje1, personajeUno);
    	this.seleccionarToggle(Personaje3, personajeTres);
    	this.juego.setPersonajeActual(this.personajeTres);
    }

    @FXML
    void Transformar(ActionEvent event) throws IOException{
    	if (accionado) return;
    	try{this.juego.transformar();}catch(TransformacionMegabotException e){this.mostrarError(e.getMessage());return;}
    	this.setEstiloToggle(this.personajeActual.getNombreEstado(), this.toggleActual); 
    	this.tablero.armarTablero(this.juego);
    	this.setJugador(this.juego.getJugadorActual());
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/Transformacion.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    	this.finAccion();
    }
    
    public void armarTablero(){
    	this.tablero.armarTablero(this.juego);
    }
    
    private void mostrarError(String mensaje) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorError.fxml"));
    	VBox contenedorError = (VBox) loader.load();
    	ControladorError controlador = loader.<ControladorError>getController();
    	controlador.initData(mensaje);
    	Stage stage = new Stage();
		stage.setTitle("Error");
    	stage.setScene(new Scene(contenedorError));
    	stage.show();
    }
    
    public void setPersonajes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
    	if (uno != null){
    		this.personajeUno = uno;
    		this.setEstiloToggle(uno.getNombreEstado(), this.Personaje1);
    		this.setEstiloLabel(this.Vida1, "Vida: ", uno.getVida());
    		this.setEstiloLabel(this.Poder1, "Poder: ", uno.getAtaque());
    		this.setEstiloLabel(this.Rango1, "Rango: ", uno.getDistanciaDeAtaque());
    		this.setEstiloLabel(this.Vel1, "Vel: ", uno.getVelocidad());
    	} else {this.desactivar(Personaje1, Vida1, Poder1, Rango1, Vel1);}
    	if (dos != null){
    		this.personajeDos = dos;
    		this.setEstiloToggle(dos.getNombreEstado(), this.Personaje2);
    		this.setEstiloLabel(this.Vida2, "Vida: ", dos.getVida());
    		this.setEstiloLabel(this.Poder2, "Poder: ", dos.getAtaque());
    		this.setEstiloLabel(this.Rango2, "Rango: ", dos.getDistanciaDeAtaque());
    		this.setEstiloLabel(this.Vel2,"Vel: ",  dos.getVelocidad());
    	} else {this.desactivar(Personaje2, Vida2, Poder2, Rango2, Vel2);}
    	if (tres != null){
    		this.personajeTres = tres;
    		this.setEstiloToggle(tres.getNombreEstado(), this.Personaje3);
    		this.setEstiloLabel(this.Vida3, "Vida: ", tres.getVida());
    		this.setEstiloLabel(this.Poder3, "Poder: ", tres.getAtaque());
    		this.setEstiloLabel(this.Rango3, "Rango: ", tres.getDistanciaDeAtaque());
    		this.setEstiloLabel(this.Vel3, "Vel: ", tres.getVelocidad());
    	} else {this.desactivar(Personaje3, Vida3, Poder3, Rango3, Vel3);}
    	this.focusActual(this.juego.getPersonajeActual());
    }
    
    private void setEstiloLabel(Label etiqueta, String base, int valor){
    	etiqueta.setVisible(true);
    	etiqueta.setAlignment(Pos.CENTER);
    	etiqueta.setText(base + valor);
    }
    
    private void focusActual(AlgoFormer personaje){
    	if (personaje == this.personajeUno) this.seleccionarToggle(Personaje1, personajeUno);
    	if (personaje == this.personajeDos) this.seleccionarToggle(Personaje2, personajeDos);
    	if (personaje == this.personajeTres) this.seleccionarToggle(Personaje3, personajeTres);
    }
    
    private void desactivar(ToggleButton boton, Label vida, Label poder, Label rango, Label velocidad){
    	boton.setGraphic(null);
    	boton.setVisible(false);
    	boton.setDisable(true);
    	this.desactivarLabel(vida);
    	this.desactivarLabel(poder);
    	this.desactivarLabel(rango);
    	this.desactivarLabel(velocidad);
    }
    
    private void desactivarLabel(Label label){
    	label.setVisible(false);
    }
    
    private void setEstiloToggle(String nombre, ToggleButton boton){
    	boton.setGraphic(new ImageView(new Image((("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombre + ".png")))));
    	boton.setStyle("-fx-background-color: transparent;");
    	boton.setVisible(true);
    	boton.setDisable(false);
    }
    
    private void deseleccionarToggle(ToggleButton boton, AlgoFormer personaje){
    	boton.setSelected(false);
    	boton.setStyle("-fx-background-color: transparent;");
    }
    
    private void seleccionarToggle(ToggleButton boton, AlgoFormer personaje){
    	this.personajeActual = personaje;
    	this.toggleActual = boton;
    	boton.setSelected(true);
    	boton.requestFocus();
    	boton.setStyle("-fx-shadow: black");
    }

    private void setDisenioBotones(){
    	this.setDisenio(this.BotonAtacar, "Atacar", 36, 100);
    	this.setDisenio(this.BotonCombinar, "Combinar", 36, 100);
    	this.setDisenio(this.BotonMover, "Mover", 36, 100);
    	this.setDisenio(this.BotonTransformar, "Transformar", 36, 140);
    	this.setDisenio(this.BotonFinalizarTurno, "FinalizarTurno", 72, 103);
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
    
	public void initData(Juego juego) {
		this.juego = juego;	
		this.setDisenioBotones();
		this.setJugador(juego.getJugadorActual());
	}
	
	public void setJugador(Jugador jugador){
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

	public void initTablero(ContenedorTablero tablero) {
		this.tablero = tablero;
	}
	
	private void setBackground(BorderPane contenedor) {
		Image imagen = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));
	}
	
    private void setBackgroundVictoria(VBox contenedor) {
		Image imagen = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));
	}

}


package fiuba.algo3.algoFormers.vista.eventos;

import java.io.File;
import java.io.IOException;

import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.direcciones.DirIzquierda;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ControladorMovimiento {

    @FXML
    private Label NotificacionError;
    @FXML
    private GridPane Grid;
    @FXML
    private Button BotonArriba;
    @FXML
    private Button BotonAbajo;
    @FXML
    private Button BotonIzqArr;
    @FXML
    private Button BotonArrDer;
    @FXML
    private Button BotonIzquierda;
    @FXML
    private Button BotonDerecha;
    @FXML
    private Button BotonAbajoIzq;
    @FXML
    private Button BotonAbjDer;
    @FXML
    private Button BotonCancelarMovimiento;

	private Juego juego;
	private ControladorJuego controlador;
	private ContenedorTablero tablero;
	private Button botonMover;
	private static final String normal = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private static final String presionado = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";

    @FXML
    void CancelarMovimiento(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	this.cerrarStage(event);
    	this.botonMover.setDisable(false);
    }
    
    private void mostrarError(String mensaje) throws IOException{
		this.NotificacionError.setText(mensaje);
    }

    @FXML
    void MoverAbajo(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajo();
    	this.mover(dir, event);
    }

    private void mover(Direccion direccion, ActionEvent event) throws IOException{
    	try{this.juego.mover(direccion);}
    	catch(FueraDelMapaException | CasilleroOcupadoException | MovimientosAgotadosException e){
    		this.mostrarError(e.getMessage());
    		return;
    	} 
    	catch(FinDelJuegoException e){
        	this.redibujarTablero();
    		this.controlador.finalizarJuego();
    		return;
    	}
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/Mover.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    	this.redibujarTablero();
    	this.controlador.accionado();
    }
    
    @FXML
    void MoverAbajoIzq(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajoIzq();
    	this.mover(dir, event);
    }

    @FXML
    void MoverAbjDer(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajoDer();
    	this.mover(dir, event);
    }

    @FXML
    void MoverArrDer(ActionEvent event) throws IOException{
    	Direccion dir = new DirArribaDer();
    	this.mover(dir, event);
    }

    @FXML
    void MoverArriba(ActionEvent event) throws IOException{
    	Direccion dir = new DirArriba();
    	this.mover(dir, event);
    }

    @FXML
    void MoverDerecha(ActionEvent event) throws IOException{
    	Direccion dir = new DirDerecha();
    	this.mover(dir, event);
    }

    @FXML
    void MoverIzqArr(ActionEvent event) throws IOException{
    	Direccion dir = new DirArribaIzq();
    	this.mover(dir, event);
    }

    @FXML
    void MoverIzquierda(ActionEvent event) throws IOException{
    	Direccion dir = new DirIzquierda();
    	this.mover(dir, event);
    }
    
    private void cerrarStage(ActionEvent event){
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    private void redibujarTablero(){
    	this.tablero.armarTablero(this.juego);
    }
    
    private void setDisenioBotones(){
    	this.setDisenio(this.BotonAbajo, "Abajo", 50, 50);
    	this.setDisenio(this.BotonArriba, "Arriba", 50, 50);
    	this.setDisenio(this.BotonDerecha, "Derecha", 50, 50);
    	this.setDisenio(this.BotonIzquierda, "Izquierda", 50, 50);
    	this.setDisenio(this.BotonAbjDer, "AbajoDerecha", 50, 50);
    	this.setDisenio(this.BotonAbajoIzq, "AbajoIzquierda", 50, 50);
    	this.setDisenio(this.BotonArrDer, "ArribaDerecha", 50, 50);
    	this.setDisenio(this.BotonIzqArr, "ArribaIzquierda", 50, 50);
    	this.setDisenio(this.BotonCancelarMovimiento, "Cancelar", 54, 150);
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
    
    private void setDisenioGrid(){
	   	Image imagenPanel = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
	   	BackgroundImage imagen = new BackgroundImage(imagenPanel,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.Grid.setBackground(new Background(imagen));
    }
    
	public void initData(Juego juego, ContenedorTablero tablero, ControladorJuego controlador, Button botonMover) {
		this.tablero = tablero;
		this.juego = juego;
		this.controlador = controlador;
		this.botonMover = botonMover;
//		this.setDisenioGrid();
		this.setDisenioBotones();
	}

}
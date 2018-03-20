package fiuba.algo3.algoFormers.vista;


import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.eventos.ControladorBienvenida;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{
	
	private Stage primaryStage;
	
	public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
    	this.primaryStage = primaryStage;
    	Juego juego = new Juego();
    	
    	//Se carga el contenedor de bienvenida y se define su imagen de fondo
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorBienvenida.fxml"));
    	BorderPane contenedorBienvenida = loader.load();
    	Image imagen = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/2704.jpg");//si se cambia la imagen, cambiar esto
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorBienvenida.setBackground(new Background(imagenDeFondo));
        
        //Se agrega el contenedor de bienvenida al stage principal como una escena
        this.primaryStage.setTitle("AlgoFormers");
    	this.primaryStage.setScene(new Scene(contenedorBienvenida, 640, 480));
    	//obtengo el controlador para asignarle el juego
    	ControladorBienvenida controlador = loader.<ControladorBienvenida>getController();
    	controlador.initData(juego);
        this.primaryStage.setFullScreen(true);
        this.primaryStage.show();
    }

	public void comenzarJuego(Scene proximaEscena) throws Exception {
		this.primaryStage.setScene(proximaEscena);
		this.primaryStage.show();
	}
}

	


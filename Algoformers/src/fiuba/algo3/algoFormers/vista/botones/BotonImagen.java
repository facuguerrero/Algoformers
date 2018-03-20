package fiuba.algo3.algoFormers.vista.botones;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BotonImagen extends Button{

	private final static String normal = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private final static String presionado = "-fx-background-color: transparent; -fx-padding: 7 3 3 7;";
    
    public BotonImagen(String urlImagen, int ancho, int alto) {
    	this.setGrafico(urlImagen, ancho, alto);
        this.setStyle(normal);
        this.setEnPresion();
        this.setAlSoltar();
   }
    
    private void setGrafico(String urlImagen, int ancho, int alto){
    	ImageView imagen = new ImageView(new Image(urlImagen));
    	imagen.setFitHeight(alto);
    	imagen.setFitWidth(ancho);
    	this.setGraphic(imagen);
    }
   
    private void setEnPresion(){
    	this.setOnMousePressed(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {setStyle(presionado);}});
    }
   
    private void setAlSoltar(){
    	this.setOnMouseReleased(new EventHandler<MouseEvent>() {
    		@Override
    		public void handle(MouseEvent event) {setStyle(normal);}});
    }
}
package fiuba.algo3.algoFormers.vista.contenedores;

import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

public class ContenedorTablero extends GridPane{

	public void armarTablero(Juego juego) {
		for(int i = 0; i < 40; i++){
    		for(int j = 0; j < 40; j++){
    			Posicion posicion = new Posicion(i,j);
    			SuperficieTerrestre supTerrestre = juego.getSuperficieTerrestre(posicion);
    			SuperficieAerea supAerea = juego.getSuperficieAerea(posicion);
    			AlgoFormer algoformer = (AlgoFormer) juego.getAtacable(posicion);
    			AnchorPane casillero = new AnchorPane();
    			Capturable capturable = juego.getCapturable(posicion);
    			
    			//se dibujan y setean la superficies
    			String nombreSupT = supTerrestre.getNombre();
    			Image imagenTerrestre = new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreSupT + ".png"));
    	        String nombreSupA = supAerea.getNombre();
    	        if (nombreSupA != "Nube"){
    	        	//se define la terrestre como fondo
    	        	BackgroundImage imagenDeFondo = new BackgroundImage(imagenTerrestre, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        	        casillero.setBackground(new Background(imagenDeFondo));
    	        	//se superpone la aerea
        	        ImageView imagenAerea = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreSupA + ".png")));
    	        	casillero.getChildren().add(imagenAerea);
    	        }else{
    	        	//solo de define la terrestre
    	        	ImageView imagen = new ImageView(imagenTerrestre);
    	        	casillero.getChildren().add(imagen);
    	        }
    	        
    	        //se agrega al algoformer
    	        if(algoformer != null){
    	        	String nombreAlgoformer = algoformer.getNombreEstado();
    	        	ImageView imagenAlgoformer = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreAlgoformer + ".png")));
    	        	casillero.getChildren().add(imagenAlgoformer);
    	        }
    	        
    	        //se agrega al bonus
    	        if(capturable != null){
    	        	String nombreCapturable = capturable.getNombre();
    	        	ImageView imagenCapturable = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreCapturable + ".png")));
    	        	casillero.getChildren().add(imagenCapturable);
    	        }
    	        
    			this.add(casillero, i, j);
//    			//agrega foco principal si es el personaje principal
//	        	if(algoformer != null && algoformer.getNombre() == juego.getPersonajeActual().getNombre()){
//	        		casillero.requestFocus();
//	        	}
    		}
		}	
	}
}

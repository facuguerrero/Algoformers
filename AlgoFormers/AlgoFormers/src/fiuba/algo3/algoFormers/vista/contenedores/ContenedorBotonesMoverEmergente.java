package fiuba.algo3.algoFormers.vista.contenedores;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ContenedorBotonesMoverEmergente extends GridPane{
	
	private Button arriba;
	private Button abajo;
	private Button arribaIzq;
	private Button arribaDer;
	private Button izquierda;
	private Button derecha;
	private Button abajoIzq;
	private Button abajoDer;

	public ContenedorBotonesMoverEmergente(Button arriba, Button abajo, Button derecha, Button izquierda,
			Button arribaDer, Button arribaIzq, Button abajoDer, Button abajoIzq){
		super();
		
		this.setArriba(arriba);
		this.setAbajo(abajo);
		this.setDerecha(derecha);
		this.setIzquierda(izquierda);
		this.setArribaDerecha(arribaDer);
		this.setArribaIzquierda(arribaIzq);
		this.setAbajoDerecha(abajoDer);
		this.setAbajoIzquierda(abajoIzq);
		
		this.distribuirBotones();
		this.setAlignment(Pos.CENTER);
	}
	
	private void distribuirBotones(){
		this.add(this.arribaIzq, 0, 0);
		this.add(this.arriba, 1, 0);
		this.add(this.arribaDer, 2, 0);
		this.add(this.izquierda, 0, 1);
		this.add(this.derecha, 2, 1);
		this.add(this.abajoIzq, 0, 2);
		this.add(this.abajo, 1, 2);
		this.add(this.abajoDer, 2, 2);
	}
	
	private void setArriba(Button arriba){this.arriba = arriba;}
	private void setAbajo(Button abajo){this.abajo = abajo;}
	private void setIzquierda(Button izquierda){this.izquierda = izquierda;}
	private void setDerecha(Button derecha){this.derecha = derecha;}
	private void setArribaIzquierda(Button arribaIzq){this.arribaIzq = arribaIzq;}
	private void setArribaDerecha(Button arribaDer){this.arribaDer = arribaDer;}
	private void setAbajoIzquierda(Button abajoIzq){this.abajoIzq = abajoIzq;}
	private void setAbajoDerecha(Button abajoDer){this.abajoDer = abajoDer;}

}

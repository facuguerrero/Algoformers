package fiuba.algo3.algoFormers.entrega2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.direcciones.DirIzquierda;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class MovimientosTest {
	
	
	@Test
	public void testUbicarAlfoFormerYMoverDerecha(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(0,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirDerecha direccionD = new DirDerecha();
		
		optimus.moverEnDireccion(direccionD, mapa);	
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 19)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverDerechaDoble(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(0,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirDerecha direccionD = new DirDerecha();
		
		optimus.moverEnDireccion(direccionD, mapa);	
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 19)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));
		
		optimus.moverEnDireccion(direccionD, mapa);
		assertEquals(optimus, mapa.getAtacable(new Posicion(2,19)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverIzquierda(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(0,19);
		Posicion posicionB = new Posicion(1,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);	
		
		DirIzquierda direccionI = new DirIzquierda();
		bumblebee.moverEnDireccion(direccionI, mapa);
		assertEquals(bumblebee, mapa.getAtacable(new Posicion(0, 20)));
		assertEquals(optimus, mapa.getAtacable(posicionO));
		assertEquals(ratchet, mapa.getAtacable(posicionR));	
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverArriba(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(0,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirArriba direccion = new DirArriba();
		
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus, mapa.getAtacable(new Posicion(0, 18)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));	
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverAbajo(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(1,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirAbajo direccion = new DirAbajo();
		
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet, mapa.getAtacable(new Posicion(0, 22)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(optimus, mapa.getAtacable(posicionO));	
	}
	
	
	@Test
	public void testUbicarAlfoFormerYMoverAbajoDerecha(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(1,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirAbajoDer direccion = new DirAbajoDer();
		
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet, mapa.getAtacable(new Posicion(1, 22)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(optimus, mapa.getAtacable(posicionO));	
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverArribaIzquierda(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(1,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirArribaIzq direccion = new DirArribaIzq();
		
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus, mapa.getAtacable(new Posicion(0, 18)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));	
	}
	
	@Test
	public void testUbicarAlfoFormerYMoverArribaDerecha(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee= factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		Mapa mapa = new Mapa();
		Posicion posicionO = new Posicion(1,19);
		Posicion posicionB = new Posicion(0,20);
		Posicion posicionR = new Posicion(0,21);
		mapa.ubicar(optimus, posicionO);
		mapa.ubicar(bumblebee, posicionB);
		mapa.ubicar(ratchet, posicionR);
		DirArribaDer direccion = new DirArribaDer();
		
		optimus.moverEnDireccion(direccion, mapa);	
		assertEquals(optimus, mapa.getAtacable(new Posicion(2, 18)));
		assertEquals(bumblebee, mapa.getAtacable(posicionB));
		assertEquals(ratchet, mapa.getAtacable(posicionR));	
	}
}
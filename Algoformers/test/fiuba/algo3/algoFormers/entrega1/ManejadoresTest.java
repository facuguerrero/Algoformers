package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class ManejadoresTest {
	
	@Test
	public void testCrearManejadorMovimientos(){
		int movimientos = 3;
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		assertNotNull(manejador);
	}
	
	@Test
	public void testVerificarMovimientosRestantesSinMover(){
		int movimientos =3;
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		assertTrue(manejador.getMovimientosRestantes() == movimientos);
	}
	
	@Test 
	public void testVerificarMovimientosRestantesConMovimiento(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		int movimientos = optimusPrime.getVelocidad();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);		
		mapa.ubicar(optimusPrime, posicionOptimus);
		DirDerecha direc = new DirDerecha();
	
		manejador.moverEnDireccion(optimusPrime,direc, mapa);
		/*EN ESTA FUNCION SE LLAMA A LA QUE TIENEN QUE IMPLEMENTAR
		EN MAPA: mapa.moverAlgoformerEnDireccion(algoformer,direccion)
		*/
	
		assertTrue(manejador.getMovimientosRestantes() == movimientos-1);
	}
	
	@Test(expected=MovimientosAgotadosException.class)
	public void testVerificarMovimientosRestantes(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		int movimientos = optimusPrime.getVelocidad();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicar(optimusPrime, posicionOptimus);
		DirDerecha direc = new DirDerecha();
		
		for(int x=0; x< movimientos+1; x++){
			manejador.moverEnDireccion(optimusPrime,direc, mapa);
		}
	}	
		
	@Test 
	public void testCrearManejadorAtaque(){
		int poder = 5;
		int distancia= 6;
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(poder,distancia);
		assertNotNull(manejador);
	}
	
	@Test
	public void testAtaqueEnRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer megatron = factory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionMegatron = new Posicion(1, 3);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(megatron, posicionMegatron);
		
		int vida = megatron.getVida();
		int poder = optimus.getAtaque();
		int distancia = optimus.getDistanciaDeAtaque();
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(poder, distancia);
		manejador.atacar(optimus, posicionMegatron, mapa);
		/*FUNCION EN LA QUE SE LLAMA A LA FUNCION QUE TIENEN QUE IMPLEMENTAR:
		 * mapa.atacarPosicion(algoformer, this.poderAtaque, this.distanciaAtaque, posicion)
		 * 
		 * ahi tienen que chequear que el ataque este dentro del rango (para eso se pasa la distancia)
		 * y que en la posicion que se ataca haya algo. yo ya chequeo en otro lado que sea amigo o enemigo.
		 */
		
		assertTrue(megatron.getVida() == (vida-optimus.getAtaque()));
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void testAtaqueFueraDeRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer megatron = factory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionAtaque = new Posicion(1, 7);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(megatron, posicionAtaque);
		int poder = optimus.getAtaque();
		int distancia = optimus.getDistanciaDeAtaque();
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(poder, distancia);
		manejador.atacar(optimus, posicionAtaque, mapa);
	}
	
	@Test(expected=AtaqueEspacioVacioException.class)
	public void testAtaqueEspacioVacio(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionAtaque = new Posicion(1, 2);
		mapa.ubicar(optimus, posicionOptimus);
		
		int poder = optimus.getAtaque();
		int distancia = optimus.getDistanciaDeAtaque();
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(poder, distancia);
		manejador.atacar(optimus, posicionAtaque, mapa);
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAutoBotAtacaAutoBot(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee = factory.getBumblebee();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionBumblebee = new Posicion(1, 2);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(bumblebee, posicionBumblebee);
		
		int poder = optimus.getAtaque();
		int distancia = optimus.getDistanciaDeAtaque();
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(poder, distancia);
		manejador.atacar(optimus, posicionBumblebee, mapa);
	}
	
}


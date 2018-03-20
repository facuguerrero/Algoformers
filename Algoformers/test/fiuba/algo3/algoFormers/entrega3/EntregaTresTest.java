package fiuba.algo3.algoFormers.entrega3;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.BurbujaInmaculada;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.DobleCanion;
import fiuba.algo3.algoFormers.modelo.capturables.bonus.Flash;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class EntregaTresTest {
	
/*	@Test
	public void testVerificarDanioConDobleCanionDuranteDiezTurnos(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		Decepticon megatron = (Decepticon) factory.getMegatron();
		
		DobleCanion dobleCanion = new DobleCanion();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		Posicion posicionMegatron = new Posicion(1,3);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(dobleCanion, posicionBonus);
		mapa.ubicar(megatron, posicionMegatron);

		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.finalizarTurno();
		
		for (int i = 0; i < 10; i++){
			optimus.atacarPosicion(posicionMegatron, mapa);
			if (i < 3){
				assertEquals(450, megatron.getVida());
			}
			if (i >= 3){
				assertEquals(500, megatron.getVida());
			}
			megatron.resetearVida();
			optimus.finalizarTurno();
		}
	}
	
	@Test
	public void testVerificarDanioBurbujaInmaculadaDuranteTresTurnos(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		Decepticon megatron = (Decepticon) factory.getMegatron();
		
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		Posicion posicionMegatron = new Posicion(1,3);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(burbuja, posicionBonus);
		mapa.ubicar(megatron, posicionMegatron);

		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.finalizarTurno();
		
		for (int i = 0; i < 3; i++){
			megatron.atacarPosicion(posicionBonus, mapa);
			if (i < 2){
				assertEquals(500, optimus.getVida());
			} else {
				assertEquals(490, optimus.getVida());
			}
			megatron.resetearVida();
			optimus.finalizarTurno();
		}
	}

	@Test
	public void testVerificarVelocidadHumanoideTriplicaConFlashDuranteTresTurnos(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		
		Flash flash = new Flash();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(flash, posicionBonus);

		Direccion direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);
		optimus.finalizarTurno();
		//Tres turnos con efecto
		for (int j = 0; j < 3; j++){	
			for (int i = 0; i < 6; i++){
				optimus.moverEnDireccion(direccion, mapa);
			}
			optimus.finalizarTurno();
		}
		for (int i = 0; i < 2; i++){
			optimus.moverEnDireccion(direccion, mapa);
		}
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 22)));
	}
	
	@Test
	public void testVerificarVelocidadAlternoTriplicaConFlashDuranteTresTurnos(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		optimus.transformarse();
		
		Flash flash = new Flash();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(flash, posicionBonus);

		Direccion arriba = new DirArriba();
		optimus.moverEnDireccion(arriba, mapa);
		optimus.finalizarTurno();
		
		Direccion abajo = new DirAbajo();
		//Tres turnos con efecto
		for (int i = 0; i < 15; i++){
			optimus.moverEnDireccion(arriba, mapa);
		}
		optimus.finalizarTurno();
		for (int i = 0; i < 15; i++){
			optimus.moverEnDireccion(abajo, mapa);
		}
		optimus.finalizarTurno();
		for (int i = 0; i < 15; i++){
			optimus.moverEnDireccion(arriba, mapa);
		}
		optimus.finalizarTurno();
		//Fin de bonus
		for (int i = 0; i < 5; i++){
			optimus.moverEnDireccion(abajo, mapa);
		}
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 12)));
	}
	
	@Test(expected = MovimientosAgotadosException.class)
	public void testCantidadDeMovimientosDisponiblesSeRestauraAlFinalizarFlash(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		
		Flash flash = new Flash();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(flash, posicionBonus);

		Direccion direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);
		optimus.finalizarTurno();
		//Tres turnos con efecto
		for (int j = 0; j < 3; j++){
			for (int i = 0; i < 6; i++){
				try{
					optimus.moverEnDireccion(direccion, mapa);
				} catch(MovimientosAgotadosException e){
					assertTrue(false); //Aca no deberia tirar error				
				}
			}
			optimus.finalizarTurno();
		}
		//Fin de bonus
		for (int i = 0; i < 2; i++){
			optimus.moverEnDireccion(direccion, mapa);
		}
		optimus.moverEnDireccion(direccion, mapa); //Esto deberia tirar error
	}
	
	@Test
	public void testVerificarEfectoFlashSeMantieneConTransformacionHumanoideEnAlterno(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		
		Flash flash = new Flash();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(2,1);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(flash, posicionBonus);

		Direccion direccion = new DirDerecha();
		optimus.moverEnDireccion(direccion, mapa);
		optimus.finalizarTurno();
		optimus.transformarse();
		optimus.finalizarTurno();
		//Tres turnos con efecto	
		for (int i = 0; i < 15; i++){
			optimus.moverEnDireccion(direccion, mapa);
		}
		optimus.finalizarTurno();
		assertEquals(optimus, mapa.getAtacable(new Posicion(17, 1)));
	}
	
	@Test
	public void testVerificarEfectoFlashSeMantieneConTransformacionAlternoEnHumanoide(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		
		Flash flash = new Flash();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(flash, posicionBonus);

		Direccion direccion = new DirArriba();
		optimus.transformarse();//Alterno
		optimus.finalizarTurno();
		optimus.moverEnDireccion(direccion, mapa);
		optimus.finalizarTurno();
		optimus.transformarse();//Humanoide
		//Tres turnos con efecto	
		for (int i = 0; i < 6; i++){
			optimus.moverEnDireccion(direccion, mapa);
		}
		optimus.finalizarTurno();
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 8)));
	}
	
	@Test
	public void testSePuedenAgarrarDosBonusDistintosYAmbosFuncionan(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		Decepticon megatron = (Decepticon) factory.getMegatron();
		
		DobleCanion dobleCanion = new DobleCanion();
		BurbujaInmaculada burbuja = new BurbujaInmaculada();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBurbuja = new Posicion(1,2);
		Posicion posicionCanion = new Posicion(1,3);
		Posicion posicionMegatron = new Posicion(1,4);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(dobleCanion, posicionCanion);
		mapa.ubicar(burbuja, posicionBurbuja);
		mapa.ubicar(megatron, posicionMegatron);

		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.finalizarTurno();
		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.finalizarTurno();

		optimus.atacarPosicion(posicionMegatron, mapa);
		assertEquals(450, megatron.getVida());
		megatron.atacarPosicion(posicionCanion, mapa);
		assertEquals(500, optimus.getVida());	
	}*/
}

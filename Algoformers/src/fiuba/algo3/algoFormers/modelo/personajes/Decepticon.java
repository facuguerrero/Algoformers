package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class Decepticon extends AlgoFormer{

	public Decepticon(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	public void recibirDanio(Decepticon decepticon, int poderAtaque){
		throw new FuegoAmigoException();
	}
	
	public void recibirDanio(AutoBot autobot, int poderAtaque){
		this.vida.descontarVida(poderAtaque);
	}
	
	public void atacarEnemigo(AlgoFormer algoformerEnemigo, int poderAtaque){
		algoformerEnemigo.recibirDanio(this,poderAtaque);
	}
}

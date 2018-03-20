package fiuba.algo3.algoFormers.modelo.personajes;

import java.util.HashSet;

import fiuba.algo3.algoFormers.modelo.excepciones.TransformacionMegabotException;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;

public class Superion extends AutoBot{
	
	private HashSet<AlgoFormer> integrantes;
	
	public Superion(int vida, AlgoFormer uno, AlgoFormer dos, AlgoFormer tres) {
		super("Superion", vida, null, 3, 100, 2);
		this.setEstadoOpuesto();
		this.setIntegrantes(uno, dos, tres);
	}
	
	private void setIntegrantes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.integrantes = new HashSet<AlgoFormer>();
		this.integrantes.add(uno);
		this.integrantes.add(dos);
		this.integrantes.add(tres);
	}
	
	private void daniarIntegrantes(Decepticon decepticon, int poderAtaque){
		this.integrantes.forEach((integrante) -> integrante.recibirDanio(decepticon, poderAtaque / 3));
	}
	
	/**
	 * Tiene solo estado Humanoide.
	 */
	private void setEstadoOpuesto(){
		this.estadoDeTransformacionOpuesto = this.estadoDeTransformacionActual;
	}
	
	@Override
	public void transformarse(){
		throw new TransformacionMegabotException();
	}
	
	public Superion vida(int vida){
		this.vida = new Vida(vida);
		return this;
	}
	
	@Override
	public void recibirDanio(Decepticon decepticon, int poderAtaque){
		this.vida.descontarVida(poderAtaque);
		this.daniarIntegrantes(decepticon, poderAtaque/3);
	}
}

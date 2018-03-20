package fiuba.algo3.algoFormers.modelo.personajes;

import java.util.HashSet;

import fiuba.algo3.algoFormers.modelo.excepciones.TransformacionMegabotException;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;

public class Menasor extends Decepticon {

private HashSet<AlgoFormer> integrantes;
	
	public Menasor(int vida, AlgoFormer uno, AlgoFormer dos, AlgoFormer tres) {
		super("Menasor", vida, null, 2, 115, 2);
		this.setEstadoOpuesto();
		this.setIntegrantes(uno, dos, tres);
	}
	
	private void setIntegrantes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		this.integrantes = new HashSet<AlgoFormer>();
		this.integrantes.add(uno);
		this.integrantes.add(dos);
		this.integrantes.add(tres);
	}
	
	private void daniarIntegrantes(AutoBot autobot, int poderAtaque){
		this.integrantes.forEach((integrante) -> integrante.recibirDanio(autobot, poderAtaque));
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
	
	public Menasor vida(int vida){
		this.vida = new Vida(vida);
		return this;
	}
	
	@Override
	public void recibirDanio(AutoBot autobot, int poderAtaque){
		this.vida.descontarVida(poderAtaque);
		this.daniarIntegrantes(autobot, poderAtaque/3);
	}
	
}

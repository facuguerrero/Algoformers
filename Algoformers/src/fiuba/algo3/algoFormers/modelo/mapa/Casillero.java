package fiuba.algo3.algoFormers.modelo.mapa;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.Superficie;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class Casillero {

	private Atacable atacable;
	private Capturable capturable;
	private boolean ocupado;
	private boolean ocupadoCapturable;
	private ArrayList<Superficie> superficies;
	
	public Casillero(){
		this.atacable = null;
		this.capturable = null;
		this.ocupado = false;
		this.ocupadoCapturable = false;
		this.superficies = new ArrayList<Superficie>();
	}
	
	public void ubicar(Atacable atacable){
		this.verificarCasilleroEstaVacio();
		this.afectarConSuperficie(atacable);
		this.afectarConCapturable(atacable);
		this.setAtacable(atacable);
		this.sacarCapturable();
	}
	
	private void sacarCapturable(){
		this.capturable = null;
		this.ocupadoCapturable = false;
	}
	
	private void afectarConCapturable(Atacable atacable) {
		if (this.capturable != null){
			this.capturable.afectar(atacable);		
		}
	}

	private void afectarConSuperficie(Atacable atacable) {
		for (Superficie superficie : this.superficies){
			superficie.afectar(atacable);
		}
		
	}

	public void ubicar(Capturable capturable){
		this.verificarCasilleroCapturableEstaVacio();
		this.setCapturable(capturable);
	}
	
	public void ubicar(Superficie superficie) {
		int indiceA = this.obtenerIndiceSuperficieAerea();
		int indiceT = this.obtenerIndiceSuperficieTerrestre();
		if(indiceT >= 0 && superficie.getClass() == SuperficieTerrestre.class){
			this.superficies.remove(indiceT);
			}
		if(indiceA >= 0 && superficie.getClass() == SuperficieAerea.class){
			this.superficies.remove(indiceA);	
		}
		this.superficies.add(superficie);		
	}
	
	private void setAtacable(Atacable atacable){
		this.atacable = atacable;
		ocupado = true;
	}

	private void setCapturable(Capturable capturable) {
		this.capturable = capturable;
		this.ocupadoCapturable = true;
	}
	
	private boolean estaOcupado() {
		return this.ocupado;
	}

	private boolean estaOcupadoCapturable() {
		return ocupadoCapturable;
	}
	
	public Atacable getAtacable() {
		return this.atacable;
	}
	
	public Capturable getCapturable() {
		return this.capturable;
	}
	
	public void desocuparAtacable() {
		this.atacable = null;
		this.ocupado = false;
	}
	
	private void verificarCasilleroEstaVacio() {
		if (this.estaOcupado()){
			throw new CasilleroOcupadoException("Ya hay un personaje en este casillero");
		}
	}

	private void verificarCasilleroCapturableEstaVacio() {
		if (this.estaOcupadoCapturable()){
			throw new CasilleroOcupadoException("Ya hay un capturable en este casillero");
		}
	}
	
	public SuperficieTerrestre getSuperficieTerrestre(){
		if (this.superficies.size() == 0) return null;
		Superficie superficie = this.superficies.get(0);
		if (superficie.getClass() == SuperficieTerrestre.class){
			return (SuperficieTerrestre) superficie;
		}
		if (this.superficies.size() < 2) return null;
		return (SuperficieTerrestre) this.superficies.get(1);
	}

	public SuperficieAerea getSuperficieAerea(){
		if (this.superficies.size() == 0) return null;
		Superficie superficie = this.superficies.get(0);
		if (superficie.getClass() == SuperficieAerea.class){
			return (SuperficieAerea) superficie;
		}
		if (this.superficies.size() < 2) return null;
		return (SuperficieAerea) this.superficies.get(1);
	}
	
	public int obtenerIndiceSuperficieTerrestre(){
		if (this.superficies.size() == 0) return -1;
		Superficie superficie = this.superficies.get(0);
		if (superficie.getClass() == SuperficieTerrestre.class){
			return 0;
		}
		if (this.superficies.size() < 2) return -1;
		return 1;
	}

	public int obtenerIndiceSuperficieAerea(){
		if (this.superficies.size() == 0) return -1;
		Superficie superficie = this.superficies.get(0);
		if (superficie.getClass() == SuperficieAerea.class){
			return 0;
		}
		if (this.superficies.size() < 2) return -1;
		return 1;
	}
	
}

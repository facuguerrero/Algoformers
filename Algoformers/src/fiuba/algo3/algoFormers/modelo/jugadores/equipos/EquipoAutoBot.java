package fiuba.algo3.algoFormers.modelo.jugadores.equipos;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.Superion;

public class EquipoAutoBot extends Equipo{

	private Superion megabot;
	private boolean combinado = false;
	
	public EquipoAutoBot(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		super(uno, dos, tres);
		this.setMegaBot(uno, dos, tres);
		
	}
	
	public void setMegaBot(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres) {
		this.megabot = new Superion(this.calcularVidaMegaBot(), uno, dos, tres);
	}
	
	@Override
	protected void definirMegaBotComoActual(int vida) {
		this.personajeActual = this.megabot.vida(vida);
		this.combinado = true;
	}
	
	protected void finalizarTurnoMegaBot(){
		this.megabot.finalizarTurno();
	}
	
	protected void reubicarPersonajes(Mapa mapa){
		Posicion posMegabot = mapa.obtenerPosicion(this.megabot);
		mapa.borrarPersonaje(this.megabot);
		this.combinado = false;
		this.ubicarIntegrantesEnAlrededores(posMegabot, mapa);
	}
	
	protected void ubicarMegabot(Mapa mapa, Posicion pos){
		mapa.ubicar(this.megabot, pos);
	}
	
	public Set<AlgoFormer> getPersonajes() {
		Set<AlgoFormer> personajes = new HashSet<AlgoFormer>();
		
		if (this.combinado) personajes.add(this.megabot);
		else{
			personajes.add(this.getAlgoFormer("Optimus Prime"));
			personajes.add(this.getAlgoFormer("Bumblebee"));
			personajes.add(this.getAlgoFormer("Ratchet"));
		}
		
		return personajes;
	}
}

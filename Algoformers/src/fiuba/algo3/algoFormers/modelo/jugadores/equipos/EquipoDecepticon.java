package fiuba.algo3.algoFormers.modelo.jugadores.equipos;

import java.util.HashSet;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.Menasor;

public class EquipoDecepticon extends Equipo {

	private Menasor megabot;
	private boolean combinado = false;
	
	public EquipoDecepticon(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		super(uno, dos, tres);
		this.setMegaBot(uno, dos, tres);
	}
	
	public void setMegaBot(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres) {
		this.megabot = new Menasor(this.calcularVidaMegaBot(), uno, dos, tres);
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
		this.ubicarIntegrantesEnAlrededores(posMegabot, mapa);
	}
	
	protected void ubicarMegabot(Mapa mapa, Posicion pos){

		mapa.ubicar(this.megabot, pos);
	}
	
	public Set<AlgoFormer> getPersonajes() {
		Set<AlgoFormer> personajes = new HashSet<AlgoFormer>();
		
		if (this.combinado) personajes.add(this.megabot);
		else{
			personajes.add(this.getAlgoFormer("Megatron"));
			personajes.add(this.getAlgoFormer("Frenzy"));
			personajes.add(this.getAlgoFormer("Bonecrusher"));
		}
		return personajes;
	}
}

package fiuba.algo3.algoFormers.modelo.fabricas.superficies;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoAtaque;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoPantano;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVelocidad;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVida;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class SuperficiesFactory {
	
		
	public SuperficieTerrestre getPantano(){
		EfectoTemporal efectoPantano = new EfectoPantano();
		SuperficieTerrestre sup = new SuperficieTerrestre("Pantano", efectoPantano);
		return sup;
	}
		
	public SuperficieTerrestre getRocas(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoRocas = new EfectoTemporal(DatosS.EFECTOROCAS.getMultiplicador(),
				DatosS.EFECTOROCAS.getBase(), efectoV, DatosS.EFECTOROCAS.getTurnos());
		SuperficieTerrestre sup = new SuperficieTerrestre("Rocas", efectoRocas);
		return sup;
	}
		
	public SuperficieTerrestre getEspina(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoEspina = new EfectoTemporal(DatosS.EFECTOESPINA.getMultiplicador(),
				DatosS.EFECTOESPINA.getBase(), efectoV, DatosS.EFECTOESPINA.getTurnos());
		SuperficieTerrestre sup = new SuperficieTerrestre("Espina", efectoEspina);
		return sup;
	}
	
	public SuperficieAerea getNube(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoNube = new EfectoTemporal(DatosS.EFECTONUBE.getMultiplicador(),
				DatosS.EFECTONUBE.getBase(), efectoV, DatosS.EFECTONUBE.getTurnos());
		SuperficieAerea sup = new SuperficieAerea("Nube", efectoNube);
		return sup;
	}
	
	public SuperficieAerea getTormentaPsionica(){
		EfectoAtaque efectoA = new EfectoAtaque();
		EfectoEstatico efectoTormenta = new EfectoEstatico(DatosS.EFECTOTORMENTAPSIONICA.getMultiplicador(),
				DatosS.EFECTOTORMENTAPSIONICA.getBase(), efectoA);
		SuperficieAerea sup = new SuperficieAerea("Tormenta", efectoTormenta);
		return sup;
	}
	
	public SuperficieAerea getNebulosaAndromeda(){
		EfectoVelocidad efectoV = new EfectoVelocidad();
		EfectoTemporal efectoNebulosa = new EfectoTemporal(DatosS.EFECTONEBULOSAANDROMEDA.getMultiplicador(),
				DatosS.EFECTONEBULOSAANDROMEDA.getBase(), efectoV,
				DatosS.EFECTONEBULOSAANDROMEDA.getTurnos());
		SuperficieAerea sup = new SuperficieAerea("Nebulosa", efectoNebulosa);
		return sup;
	}	
}

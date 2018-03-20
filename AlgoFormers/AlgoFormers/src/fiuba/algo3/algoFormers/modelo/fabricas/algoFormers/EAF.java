package fiuba.algo3.algoFormers.modelo.fabricas.algoFormers;

public enum EAF {
	OPTIMUS ("Optimus Prime", 500, 2, 5, 50, 15, 2, 4),
	BUMBLEBEE ("Bumblebee", 350, 2, 5, 40, 20, 1, 3),
	RATCHET ("Ratchet", 150, 1, 8, 5, 35, 5, 2),
	MEGATRON ("Megatron", 550, 1, 8, 10, 55, 3, 2),
	FRENZY ("Frenzy", 400, 2, 6, 10, 25, 5, 2),
	BONECRUSHER ("Bonecrusher", 200, 1, 8, 30, 30, 3, 3);

	private final String nombre;
	private final int vida;
	private final int velHum;
	private final int velAlt;
	private final int ataqueHum;
	private final int ataqueAlt;
	private final int distAtHum;
	private final int distAtAlt;
	EAF(String nombre, int vida, int velHum, int velAlt, int ataqueHum, int ataqueAlt, int distAtHum, int distAtAlt){
		this.nombre = nombre;
		this.vida = vida;
		this.velHum = velHum;
		this.velAlt = velAlt;
		this.ataqueHum = ataqueHum;
		this.ataqueAlt = ataqueAlt;
		this.distAtHum = distAtHum;
		this.distAtAlt = distAtAlt;
	}
	
	public String nombre(){ return nombre; }
	public int vida(){ return vida; }
	public int velH(){ return velHum; }
	public int velA(){ return velAlt; }
	public int atH(){ return ataqueHum; }
	public int atA(){ return ataqueAlt; }
	public int dAtH(){ return distAtHum; }
	public int dAtA(){ return distAtAlt; }
	
}
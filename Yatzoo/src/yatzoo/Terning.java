package yatzoo;

/**
 * En enum klasse for en terning som gir heltallsverdier som korresponderer med alle sidene på terningen.
 * 
 * @author Arja Sivapiragasam
 * @author Raida Talukdar
 *
 */
public enum Terning {
	LØVE(1), SLANGE(2), PANDA(3), GRIS(4), ELEFANT(5), HVAL(6);
	private int nr;

	private Terning(int n) { // Konstruktør
		this.nr = n;
	}

	public int getNr() {
		return nr;
	}

	/**
	 * henter dyret i form av en terning fra det korresponderende tallet.
	 * 
	 * @param n tall som tilhører et dyr i enum listen.
	 * @return Et terning objekt som representerer dyret.
	 */
	public static Terning finnDyr(int n) {
		Terning dyret = null;
		for (Terning dyr : Terning.values()) {
			if (dyr.nr == n) {
				dyret = dyr;
				break;
			}
		}
		return dyret;
	}// metode

	/**
	 * henter dyret i form av en terning fra brukerinput.
	 * 
	 * @param input brukerinput.
	 * @return Et terning objekt som representerer dyret.
	 */
	public static Terning finnDyr(String input) {
		Terning dyret = null;
		for (Terning dyr : Terning.values()) {
			if (dyr.toString().equals(input.toUpperCase())) {
				dyret = dyr;
				break;
			}
		}
		return dyret;
	}// metode

}

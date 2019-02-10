package yatzoo;

/**
 * Definerer en spiller i Yatzoo.
 * 
 * @author Arja Sivapiragasam
 * @author Raida Talukdar
 *
 */
public class Spiller {
	/**
	 * Hver spiller har et navn og en resultatblokk
	 */
	private Resultatblokk resultatblokk;
	private String navn;

	/**
	 * Oppretter en spiller.
	 * 
	 * @param navn navn på spilleren
	 */
	public Spiller(String navn) {
		this.navn = navn;
		this.resultatblokk = new Resultatblokk();
	}

	/**
	 * Henter resultatblokk.
	 * 
	 * @return resultatblokk resultatblokken til spilleren
	 */
	public Resultatblokk getResultatblokk() {
		return resultatblokk;
	}

	/**
	 * Henter navnet til spilleren
	 * 
	 * @return navn navnet til spilleren
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Setter navnet til spilleren.
	 * 
	 * @param navn navnet på spilleren
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
}

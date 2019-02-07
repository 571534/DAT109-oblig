package yatzoo;

public class Spiller {
//alle har en resultatbokk hver
	private Resultatblokk resultatblokk; 
	private String navn; 
	
	public Spiller (String navn) {
		this.navn = navn; 
		this.resultatblokk = new Resultatblokk(); 
	}
	/*
	public void registrerPoeng(int i) {
		resultatblokk.settResultat(i); 
	}
	*/
	
	/*
	public void setResultater(Resultatblokk resultater) {
		this.resultater = resultater;
	}
	*/

	public Resultatblokk getResultatblokk () {
		return resultatblokk; 
	}
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}


package yatzoo;

public class Spiller {
//alle har en resultatbokk hver
	private Resultatblokk resultater = new Resultatblokk(); 
	private String navn; 
	
	public Spiller (String navn) {
		this.navn = navn; 
	}
	
	public void registrerPoeng(int i) {
		resultater.settInnPoeng(i); 
	}
}


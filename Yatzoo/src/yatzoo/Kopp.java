package yatzoo;
import yatzoo.Terning;
import java.util.Random;

public class Kopp {
	Terning[] terninger;
	int[] lagredeTerninger;
	int antallLagret; 
	
	public Kopp () {
		terninger = new Terning[5]; 
		lagredeTerninger = new int[5]; 
		int antallLagret = 0; 
	}
	
	public void trill() {
		Random r = new Random();
		for (int i = 0; i<5; i++) {
			if (lagredeTerninger[i] != 1) {
				int random = r.nextInt((6 - 1) + 1) + 1;
				terninger[i] = Terning.finnDyr(random);
			}
		}
	}
	
	public void lagreTerning (int i) {
		lagredeTerninger[i-1] = 1;  
	}
	
	
	public Terning[] getKopp() {
		return terninger;
	}

	public int[] getLagredeTerniger () {
		return lagredeTerninger; 
	}
	
	public void skrivUtVerdier() {
		System.out.println("Terning 1: " + terninger[0] + "\n" + "Terning 2: " + terninger[1] + "\n" + "Terning 3: " + terninger[2] + "\n" + "Terning 4: " + terninger[3] + "\n" + "Terning 5: " + terninger[4]);
		}
	
	
}

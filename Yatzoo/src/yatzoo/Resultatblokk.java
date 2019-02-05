package yatzoo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yatzoo.Terning;

public class Resultatblokk {
//metoder for å spille, bergene og legge inn poengsum i hver kategori //spillKategori1 osv 

	public int antallDyr (Kopp kopp, Terning dyr) { //antall løver
		int poengsum = 0;
		Terning[] terninger = kopp.getKopp();
		
			for (int i = 0; i < 5; i++) {
				if (terninger[i] == dyr) {
					poengsum++;
				}
			}
		return poengsum; 
	}
	
	public int antallLike (Kopp kopp, int antall) {
		int poengsum = 0; 
		Terning[] terninger = kopp.getKopp();
		int love = 0; 
		int slange = 0; 
		int panda = 0; 
		int gris = 0;  
		int elefant = 0; 
		int hval = 0; 
		
		for (int i = 0; i < 5; i++) {
			if (terninger[i] == Terning.LØVE) {
				love++; 
			} else if (terninger[i] == Terning.SLANGE) {
				slange++;
			} else if (terninger[i] == Terning.PANDA) {
				panda++;
			} else if (terninger[i] == Terning.GRIS) {
				gris++;
			} else if (terninger[i] == Terning.ELEFANT) {
				elefant++;
			} else {
				hval++; 
			}
		}
	
		List<Integer> list = List.of(love, slange, panda, gris, elefant, hval);
	//	poengsum = Collections.max(list);
		
		if (list.contains(antall)) {
			poengsum = antall;
		}
	
		return poengsum; 
	}
	
}

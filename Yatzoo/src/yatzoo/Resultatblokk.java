package yatzoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import yatzoo.Terning;

public class Resultatblokk {

	private int[] resultater;

	public Resultatblokk() {
		resultater = new int[13];
	}
//metoder for å spille, bergene og legge inn poengsum i hver kategori //spillKategori1 osv 

	public int antallDyr(Kopp kopp, Terning dyr) { // feks antall løver, kategori 1-6
		int poengsum = 0;
		Terning[] terninger = kopp.getKopp();

		for (int i = 0; i < 5; i++) {
			if (terninger[i] == dyr) {
				poengsum++;
			}
		}
		return poengsum;
	}

	public List<Integer> listAntall(Kopp kopp) {
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

		List<Integer> list = Arrays.asList(love, slange, panda, gris, elefant, hval);
		return list;
	}

	public int antallLike(Kopp kopp, int antall) { // kategori 7 og 8
		int poengsum = 0;

		List<Integer> list = listAntall(kopp);
		if (antall == 4) {
			if (list.contains(antall) || list.contains(5)) {
				poengsum = antall;
			}
		} else {
			if (list.contains(antall) || list.contains(antall + 1) || list.contains(antall + 2)) {
				poengsum = antall;
			}
		}

		return poengsum;
	}

	public int toPar(Kopp kopp) {
		int poengsum = 0;
		int teller = 0;

		List<Integer> list = listAntall(kopp);

		Iterator<Integer> iterator = list.iterator();

		while (iterator.hasNext()) {
			Integer i = iterator.next();
			if (i >= 2) {
				teller++;
			}
		}

		if (teller >= 2) {
			poengsum = 4;
		}

		return poengsum;
	}

	public int hus(Kopp kopp) {
		int poengsum = 0;
		int treLike = 0;
		List<Integer> list = listAntall(kopp);

		// Iterator<Integer> iterator = list.iterator();

		int toPar = toPar(kopp);

		if (toPar == 4) {
			if (antallLike(kopp, 3) == 3) {
				poengsum = 5;
			}
		} else {
			poengsum = 0;
		}
		/*
		 * while (iterator.hasNext()) { if (iterator.next() >= 2) { teller++; } }
		 */

		/*
		 * while (iterator.hasNext()) { // 2, 3, 1,1, 0 if (iterator.next() == 3 ||
		 * iterator.next() == 4) { Integer dyr = iterator.next(); } }
		 */

		/*
		 * if (list.contains(3) || list.contains(4)) {
		 * 
		 * }
		 */

		return poengsum;
	}

	public int alleUlike (Kopp kopp) {
		int antallUlike = 1; 
		int poengsum = 0;
		List<Integer> list = listAntall(kopp);
		Iterator<Integer> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			if (i == 1) {
				antallUlike++;
			}
		}
			
		if (antallUlike >= 5) {
			poengsum = 5;
		} 
		
		return poengsum; 

	}

	public int alleLike(Kopp kopp) {
		int poeng = 0;

		List<Integer> list = listAntall(kopp);
		if (list.contains(5)) {
			poeng = 10;
		}

		return poeng;
	}

	public void beregnTotal() {
		int poengsum = 0;
		
		for (int i : resultater) {
			poengsum = poengsum + i;
		}
		
		resultater[12] = poengsum;
	}
	
	public int getTotal () {
		return resultater[12];
	}

	public int[] getResultater() {
		return resultater;
	}
	public void setResultat(int poengsum, int runde) {
		resultater[runde] = poengsum;
	}

	public void printResultatblokk() {
		System.out.println("Antall løver: " + resultater[0]);
		System.out.println("Antall slanger: " + resultater[1]);
		System.out.println("Antall pandaer: " + resultater[2]);
		System.out.println("Antall griser: " + resultater[3]);
		System.out.println("Antall elefanter: " + resultater[4]);
		System.out.println("Antall hvaler: " + resultater[5]);
		System.out.println("Tre like: " + resultater[6]);
		System.out.println("Fire like: " + resultater[7]);
		System.out.println("To par: " + resultater[8]);
		System.out.println("Hus: " + resultater[9]);
		System.out.println("Alle ulike: " + resultater[10]);
		System.out.println("Alle like " + resultater[11]);
		System.out.println("Total: " + resultater[12]);
	}
}

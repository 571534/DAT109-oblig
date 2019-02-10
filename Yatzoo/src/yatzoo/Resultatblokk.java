package yatzoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import yatzoo.Terning;

/**
 * En resultatblokk med 13 ulike runder hvor poengsummen beregnes forskjellig.
 * 
 * @author Arja Sivapiragasam
 * @author Raida Talukdar
 *
 */
public class Resultatblokk {

	private int[] resultater;

	/**
	 * Oppretter en resultatblokk med 13 plasser.
	 */
	public Resultatblokk() {
		resultater = new int[13];
	}

	/**
	 * Teller opp ett poeng for hver instans av et spesifisert dyr. Gjelder for de
	 * første 6 rundene. F.eks.: Runde 1: Teller opp antall løver.
	 * 
	 * @param kopp kopp som brukes i spillet
	 * @param dyr  dyret som skal samles på i den spesifikke runden
	 * @return poengsummen som et heltall
	 */
	public int antallDyr(Kopp kopp, Terning dyr) {
		int poengsum = 0;
		Terning[] terninger = kopp.getKopp();

		for (int i = 0; i < 5; i++) {
			if (terninger[i] == dyr) {
				poengsum++;
			}
		}
		return poengsum;
	}

	/**
	 * Lager en liste av hvor mange instanser av hvert dyr som er tilstede i koppen.
	 * 
	 * @param kopp en kopp med 5 terninger
	 * @return en List<Integer> av antall ulike dyr
	 */
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

	/**
	 * For å finne et spesifikt antall av like terninger. 3 legges inn for Runde 7
	 * og 4 for Runde 8.
	 * 
	 * @param kopp   en kopp med 5 terninger
	 * @param antall antallet like vi vil trille
	 * @return poengsummen som et heltall
	 */
	public int antallLike(Kopp kopp, int antall) {
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

	/**
	 * Finner 2 unike par.
	 * 
	 * @param kopp en kopp med 5 terninger
	 * @return poengsummen som et heltall
	 */
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

	/**
	 * Sjekker at det er ett par og 3 like av to ulike dyr. Runde 9.
	 * 
	 * @param kopp kopp med 5 terninger
	 * @return poengsummen som et heltall
	 */
	public int hus(Kopp kopp) {
		int poengsum = 0;
		int treLike = 0;
		List<Integer> list = listAntall(kopp);

		int toPar = toPar(kopp);

		if (toPar == 4) {
			if (antallLike(kopp, 3) == 3) {
				poengsum = 5;
			}
		} else {
			poengsum = 0;
		}
		return poengsum;
	}

	/**
	 * sjekker at det ikke finnes 2 instanser av samme terning, alle må være ulike.
	 * Runde 10.
	 * 
	 * @param kopp kopp med 5 terninger
	 * @return poengsummen som et heltall
	 */
	public int alleUlike(Kopp kopp) {
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

	/**
	 * Sjekker om alle terningene er like (samme dyr). Runde 11.
	 * 
	 * @param kopp kopp med 5 terninger
	 * @return poengsummen som et heltall
	 */
	public int alleLike(Kopp kopp) {
		int poeng = 0;

		List<Integer> list = listAntall(kopp);
		if (list.contains(5)) {
			poeng = 10;
		}

		return poeng;
	}

	/**
	 * Beregner totalsummen av poengsummene og legger den inn i den siste plassen i
	 * resultatblokken.
	 */
	public void beregnTotal() {
		int poengsum = 0;

		for (int i : resultater) {
			poengsum = poengsum + i;
		}

		resultater[12] = poengsum;
	}

	/**
	 * Henter totalsummen.
	 * 
	 * @return
	 */
	public int getTotal() {
		return resultater[12];
	}

	/**
	 * Henter alle resultatverdiene.
	 * 
	 * @return
	 */
	public int[] getResultater() {
		return resultater;
	}

	/**
	 * Setter en poengsum inn på en spesifik runde.
	 * 
	 * @param poengsum poengsum representert med et heltall
	 * @param runde    hvilken runde som spilles
	 */
	public void setResultat(int poengsum, int runde) {
		resultater[runde] = poengsum;
	}

	/**
	 * Skriver ut resultatblokken
	 */
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

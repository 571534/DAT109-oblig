package yatzoo;

import yatzoo.Terning;
import java.util.Random;
import java.util.Scanner;

/**
 * For å lage en kopp med 5 terninger som kan trilles.
 * 
 * @author Arja Sivapiragasam
 * @author Raida Talukdar
 *
 */
public class Kopp {
	Terning[] terninger;
	int[] lagredeTerninger;
	int antallLagret;

	/**
	 * Oppretter en kopp.
	 */
	public Kopp() {
		terninger = new Terning[5];
		lagredeTerninger = new int[5];
		int antallLagret = 0;
	}

	/**
	 * Oppretter en kopp med en spesifisert Terning tabell.
	 * 
	 * @param terninger en tabell av Terning-objekter
	 */
	public Kopp(Terning[] terninger) {
		this.terninger = terninger;
		lagredeTerninger = new int[5];
		int antallLagret = 0;
	}

	/**
	 * Triller en kopp med terninger og plasserer random verdier på hver plass i
	 * terning-tabellen så lenge en terning ikke allerede er lagret på denne
	 * plassen.
	 */
	public void trill() {
		Random r = new Random();
		for (int i = 0; i < terninger.length; i++) {
			if (lagredeTerninger[i] != 1) {
				int random = r.nextInt((6 - 1) + 1) + 1;
				terninger[i] = Terning.finnDyr(random);
			}
		}
	}

	/**
	 * Lagrer en terning
	 * 
	 * @param i plass i tabellen (bestemt av bruker)
	 */
	public void lagreTerning(int i) {
		lagredeTerninger[i - 1] = 1;
	}

	/**
	 * fungerer på samme måte som lagreTerning, men her slettes terningen
	 * 
	 * @param i plass i tabellen (bestemt av bruker)
	 */
	public void fjernLagret(int i) {
		lagredeTerninger[i - 1] = 0;

	}

	/**
	 * Tømmer alle de lagrede terningene i koppen
	 */
	public void tomKopp() {
		lagredeTerninger = new int[5];
	}

	/**
	 * Henter verdiene/terningene i koppen
	 * 
	 * @return en tabell av terninger som representerer terningene i koppen
	 */
	public Terning[] getKopp() {
		return terninger;
	}

	/**
	 * henter de lagrede terningene
	 * 
	 * @return en tabell av heltall som markerer plassen til lagrete terninger med
	 *         et ett-tall.
	 */
	public int[] getLagredeTerninger() {
		return lagredeTerninger;
	}

	/**
	 * Skriver ut verdiene til hver terning i koppen.
	 */
	public void skrivUtVerdier() {
		System.out.println("Terning 1: " + terninger[0] + "\n" + "Terning 2: " + terninger[1] + "\n" + "Terning 3: "
				+ terninger[2] + "\n" + "Terning 4: " + terninger[3] + "\n" + "Terning 5: " + terninger[4]);
	}

}

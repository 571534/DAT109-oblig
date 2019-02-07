package yatzoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class klient {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Kopp kopp = new Kopp();
		Resultatblokk rb = new Resultatblokk();
		Spiller[] spillere = null;
		int poeng = 0;

		int runde = 0;
		int antallSpiller = 0;

		System.out.println("Hei! ");
		while (antallSpiller == 0) {
			try {
				System.out.println("Angi antall spillere: ");
				antallSpiller = Integer.parseInt(sc.nextLine());
				spillere = new Spiller[antallSpiller];
			} catch (NumberFormatException e) {
				System.out.println("Feil ved innlesning. Skriv inn et heltall.");
			}
		}

		if (antallSpiller != 0) {
			for (int i = 1; i <= antallSpiller; i++) {
				System.out.println("Angi navn på spiller nr " + i);
				String navn = sc.nextLine();
				spillere[i - 1] = new Spiller(navn);
			}

			while (runde < 2) { // (runde < 12) gir 12 runder
				System.out.println("Runde " + (runde + 1) + "\n");

				for (int i = 0; i < antallSpiller; i++) {
					boolean aktiv = true;
					System.out.println("Hei " + spillere[i].getNavn() + "\n");
					System.out.println("Din resultatblokk");
					System.out.println("-------------------------------");
					spillere[i].getResultatblokk().printResultatblokk();
					System.out.println("-------------------------------" + "\n");

					int input = 0;
					int teller = 0;
					String inputString = "0";
					kopp.tomKopp();

					while (aktiv) {
						System.out.println("Velg 1 for å trille");
						System.out.println("Velg 2 for å lagre en terning");
						System.out.println("Velg 3 for å slette en lagret terning");
						System.out.println("Velg 4 for å registere kopp");

						try {
							inputString = sc.nextLine();
							input = Integer.parseInt(inputString);
						} catch (NumberFormatException e) {
							System.out.println("Skriv inn et heltall.");
						}

						switch (input) {
						case 1:
							if (teller < 3) {
								kopp.trill();
								kopp.skrivUtVerdier();
								System.out.println();
								teller++;
							} else {
								aktiv = false;
							}
							break;
						case 2:
							System.out.println("Hvilke terninger vil du lagre? (Du kan lagre flere)");
							Scanner scanner = new Scanner(System.in);
							boolean done = false;

							while (!done) {
								try {
									String str = scanner.nextLine();
									String nystr = str.replaceAll("\\s", "").replaceAll(",", "").replaceAll("\\+", "");
									char[] array = new char[5];
									array = nystr.toCharArray();

									for (char a : array) {
										kopp.lagreTerning(Integer.parseInt(String.valueOf(a)));
									}
									done = true;
								} catch (NumberFormatException e) {
									System.out.println("Skriv inn heltall fra 1-5");
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("Skriv inn heltall fra 1-5");
								}
							}
							break;
						case 3:
							System.out.println("Hvilke terninger vil du slette? (Du kan slette flere)");
							Scanner scanner2 = new Scanner(System.in);
							boolean ferdig = false;

							while (!ferdig) {
								try {
									String str = scanner2.nextLine();
									String nystr = str.replaceAll("\\s", "").replaceAll(",", "").replaceAll("\\+", "");
									char[] array = new char[5];
									array = nystr.toCharArray();

									for (char a : array) {
										kopp.fjernLagret(Integer.parseInt(String.valueOf(a)));
									}
									ferdig = true;
								} catch (NumberFormatException e) {
									System.out.println("Skriv inn heltall fra 1-5");
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("Skriv inn heltall fra 1-5");
								}
							}
							break;
						case 4:
							aktiv = false;
							break;
						default:
							System.out.println("Skriv inn på nytt");
						}
					} // while
					if (runde == 0) {
						poeng = rb.antallDyr(kopp, Terning.LØVE);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 1) {
						poeng = rb.antallDyr(kopp, Terning.SLANGE);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
						spillere[i].getResultatblokk().beregnTotal();
					} else if (runde == 2) {
						poeng = rb.antallDyr(kopp, Terning.PANDA);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 3) {
						poeng = rb.antallDyr(kopp, Terning.GRIS);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 4) {
						poeng = rb.antallDyr(kopp, Terning.ELEFANT);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 5) {
						poeng = rb.antallDyr(kopp, Terning.HVAL);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 6) {
						poeng = rb.antallLike(kopp, 3);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 7) {
						poeng = rb.antallLike(kopp, 4);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 8) {
						poeng = rb.toPar(kopp);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 9) {
						poeng = rb.hus(kopp);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 10) {
						poeng = rb.alleUlike(kopp);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
					} else if (runde == 11) {
						poeng = rb.alleLike(kopp);
						spillere[i].getResultatblokk().setResultat(poeng, runde);
						spillere[i].getResultatblokk().beregnTotal();
					}
					System.out.println("Poengsummen er: " + poeng + "\n");
				} // for (spiller)
				runde++;
			} // runde
			for (Spiller spiller : spillere) {
				System.out.println();
				System.out.println("Resultatblokken til " + spiller.getNavn());
				System.out.println("-------------------------------");
				spiller.getResultatblokk().printResultatblokk();
				System.out.println("-------------------------------");
			}

			Integer maxPoeng = 0;
			List<Integer> totalSummer = new ArrayList<Integer>();
			for (Spiller spiller : spillere) {
				totalSummer = Arrays.asList(spiller.getResultatblokk().getTotal());
			}
				maxPoeng = Collections.max(totalSummer);

			for (Spiller spiller : spillere) {
				if (spiller.getResultatblokk().getTotal() == maxPoeng && maxPoeng > 0) {
					System.out.println("Vinneren er " + spiller.getNavn());
				} 
			}
		}
	}
}

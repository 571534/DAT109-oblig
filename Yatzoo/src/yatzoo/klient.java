package yatzoo;

import java.util.Scanner;

public class klient {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Kopp kopp = new Kopp();
		Resultatblokk rb = new Resultatblokk();
		int poeng = 0;

		int runde = 0;

		System.out.println("Hei! ");
		System.out.println("Angi antall spillere: ");
		int antallSpiller = Integer.parseInt(sc.nextLine());
		Spiller[] spillere = new Spiller[antallSpiller];

		for (int i = 1; i <= antallSpiller; i++) {
			System.out.println("Angi navn på spiller nr " + i);
			String navn = sc.nextLine();
			spillere[i - 1] = new Spiller(navn);
		}

		while (runde < 12) { //(runde  < 12) gir 12 runder
			System.out.println("Runde " + (runde+1) + "\n");
			
			for (int i = 0; i < antallSpiller; i++) {
				boolean aktiv = true;
				System.out.println("Hei " + spillere[i].getNavn() + "\n");
				System.out.println("Din resultatblokk");
				System.out.println("-------------------------------");
				spillere[i].getResultatblokk().printResultatblokk();
				System.out.println("-------------------------------" + "\n");
				
				int teller = 0;
				kopp.tomKopp();

				while (aktiv) {
					System.out.println("Velg 1 for å trille");
					System.out.println("Velg 2 for å lagre en terning");
					System.out.println("Velg 3 for å registere kopp");
					int input = sc.nextInt();

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
						String str = scanner.nextLine();
						String nystr = str.replaceAll("\\s","").replaceAll(",", ""); 
						char[] array = new char[nystr.length()];
						array = nystr.toCharArray();      
					
						for (char a : array) {
							kopp.lagreTerning(Integer.parseInt(String.valueOf(a)));
						}			
						break;
					case 3:
						aktiv = false;
							break;
					default:
						System.out.println("Skriv inn på nytt");
					}
				} //while
				if (runde == 0) {
					poeng = rb.antallDyr(kopp, Terning.LØVE);
					spillere[i].getResultatblokk().setResultat(poeng, runde);
				} else if (runde == 1) {
					poeng = rb.antallDyr(kopp, Terning.SLANGE);
					spillere[i].getResultatblokk().setResultat(poeng, runde);
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
					rb.beregnTotal();
				}	
				System.out.println("Poengsummen er: " + poeng + "\n");
			} //for (spiller)
			runde++;
		} //runde
		for (Spiller spiller : spillere) {
			spiller.getResultatblokk().printResultatblokk();
		}
	}
}

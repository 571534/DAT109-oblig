package yatzoo;

import java.util.Scanner;

public class klient {
	public static void main (String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Kopp kopp = new Kopp();
		Resultatblokk rb = new Resultatblokk();
		int poeng = 0; 
		boolean aktiv = true; 
		
		while (aktiv) {
		System.out.println("Hei! ");
		System.out.println("Velg 1 for � trille kopp");
		System.out.println("Velg 2 for � lagre en terning");
		System.out.println("Velg 3 for � registere kopp");
		int input = sc.nextInt();
		
		switch (input) {
			case 1: 
				kopp.trill();
				kopp.skrivUtVerdier();
				break;
			case 2: 
				System.out.println("Hvilken terning vil du lagre? ");
				int n = sc.nextInt();
				kopp.lagreTerning(n);
				break;
			case 3: 
				poeng =rb.antallLike(kopp, 4);
				break;
			case 4: 
				aktiv = false; 
			default: 
				System.out.println("Skriv inn p� nytt");
		}
	}
		System.out.println("Poengsummen er: " + poeng);
}
}
